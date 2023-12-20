import com.android.ndkports.MesonPortTask
import com.android.ndkports.CMakeCompatibleVersion
import com.android.ndkports.PrefabSysrootPlugin
import org.gradle.jvm.tasks.Jar

val portVersion = "2.78.3"

group = rootProject.group
version = "${portVersion}-beta-2"

plugins {
    id("maven-publish")
    id("signing")
    id("com.android.ndkports.NdkPorts")
}

dependencies {
    val ndkVersionSuffix = rootProject.extra.get("ndkVersionSuffix")
    val dependencyLibraryTypeSuffix = rootProject.extra.get("dependencyLibraryTypeSuffix")
    implementation("com.viliussutkus89.ndk.thirdparty:libiconv${ndkVersionSuffix}${dependencyLibraryTypeSuffix}:1.17-beta-3")
    implementation("com.viliussutkus89.ndk.thirdparty:proxy-libintl${ndkVersionSuffix}${dependencyLibraryTypeSuffix}:0.4.1.2")
    implementation("com.viliussutkus89.ndk.thirdparty:libffi${ndkVersionSuffix}${dependencyLibraryTypeSuffix}:3.4.4-beta-3")
    implementation("com.viliussutkus89.ndk.thirdparty:pcre2${ndkVersionSuffix}${dependencyLibraryTypeSuffix}:10.42-beta-4")
}

ndkPorts {
    ndkPath.set(File(project.findProperty("ndkPath") as String))
    source.set(project.file("glib-${portVersion}.tar.xz"))
    minSdkVersion.set(rootProject.extra.get("minSdkSupportedByNdk").toString().toInt())
}

tasks.prefab {
    generator.set(PrefabSysrootPlugin::class.java)
}

tasks.extractSrc {
    doLast {
        outDir.get().asFile.resolve("glib/meson.build").apply {
            writeText(
                readText().replace(
                    "libraries : [libintl_deps],",
                    "libraries : [libintl_deps, libffi_dep],",
                )
            )
        }

        val minSdkVersion = rootProject.extra.get("minSdkSupportedByNdk").toString().toInt()
        if (minSdkVersion < 21) {
            // usr/include/sys/epoll.h:
            // int epoll_create(int __size);
            // #if __ANDROID_API__ >= 21
            // int epoll_create1(int __flags) __INTRODUCED_IN(21);
            // #endif /* __ANDROID_API__ >= 21 */

            // Patch inspired by (taken from):
            // https://github.com/deltachat/deltachat-android/pull/2324
            // fcntl only if epoll created successfully
            outDir.get().asFile.resolve("gio/giounix-private.c").let {
                it.writeText(it.readText().replace(
                    "#include <sys/epoll.h>",
                    """
                        #include <sys/epoll.h>
                        #if __ANDROID_API__ < 21
                        #include <fcntl.h>
                        #define EPOLL_CLOEXEC O_CLOEXEC
                        static int epoll_create1(int flags) {
                            int fd = epoll_create(1);
                            if (-1 != fd && flags & O_CLOEXEC) {
                                int f = fcntl(fd, F_GETFD);
                                fcntl(fd, F_SETFD, f | FD_CLOEXEC);
                            }
                            return fd;
                        }
                        #endif

                    """.trimIndent()
                ))
            }
        }
    }
}

tasks.register<MesonPortTask>("buildPort") {
    val generatedDependencies = prefabGenerated.get().asFile
    meson {
        // meson can't find iconv
        generatedDependencies.resolve(toolchain.abi.triple).let {
            env["CFLAGS"] = "-I${it.resolve("include")}"
            env["CXXFLAGS"] = "-I${it.resolve("include")}"
            env["LDFLAGS"] = "-L${it.resolve("lib")}"
        }
    }

    doLast {
        com.android.ndkports.Abi.values().forEach { abi ->
            installDirectoryFor(abi).let { iDir ->
                val src = iDir.resolve("lib/glib-2.0/include/glibconfig.h")
                val dst = iDir.resolve("include/glib-2.0/glibconfig.h")
                try {
                    src.copyTo(dst)
                } catch (e: FileAlreadyExistsException) {
                    if (!src.readBytes().contentEquals(dst.readBytes())) {
                        throw RuntimeException(
                            "Found duplicate config files with non-equal contents: include/glib-2.0/glibconfig.h"
                        )
                    }
                }

                iDir.resolve("lib/pkgconfig/glib-2.0.pc").let {
                    it.writeText(it.readText()
                        .replace("-I\${libdir}/glib-2.0/include", "")
                    )
                }
            }
        }
    }
}

tasks.prefabPackage {
    version.set(CMakeCompatibleVersion.parse(portVersion))

    licensePath.set("COPYING")

    dependencies.set(mapOf(
        "libiconv" to "1",
        "proxy-libintl" to "1",
        "libffi" to "1",
        "pcre2" to "1",
    ))

    modules {
        val isStatic = project.findProperty("libraryType") == "static"
        create("glib-2.0") {
            includesPerAbi.set(true)
            static.set(isStatic)
            dependencies.set(listOf(
                "//proxy-libintl:intl",
                "m",
                "//libiconv:iconv",
                "//pcre2:pcre2-8",
                "//libffi:ffi",
            ))
        }
        create("gio-2.0") {
            includesPerAbi.set(true)
            static.set(isStatic)
            dependencies.set(listOf(
                "//proxy-libintl:intl",
                ":glib-2.0",
                ":gobject-2.0",
                ":gmodule-2.0",
                "z",
            ))
        }
        create("gmodule-2.0") {
            includesPerAbi.set(true)
            static.set(isStatic)
            dependencies.set(listOf(
                "//proxy-libintl:intl",
                ":glib-2.0",
            ))
        }
        create("gobject-2.0") {
            includesPerAbi.set(true)
            static.set(isStatic)
            dependencies.set(listOf(
                "//proxy-libintl:intl",
                ":glib-2.0",
                "//libffi:ffi",
            ))
        }
        create("gthread-2.0") {
            includesPerAbi.set(true)
            static.set(isStatic)
            dependencies.set(listOf(
                "//proxy-libintl:intl",
                ":glib-2.0",
            ))
        }
    }
}

val packageSources = tasks.register<Jar>("packageSources") {
    archiveClassifier.set("sources")
    from(projectDir.resolve("build.gradle.kts"))
    from(ndkPorts.source)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["prefab"])
            artifactId += rootProject.extra.get("ndkVersionSuffix")
            artifactId += rootProject.extra.get("libraryTypeSuffix")
            artifact(packageSources)
            pom {
                name.set("GLib")
                description.set("GLib provides the core application building blocks for libraries and applications written in C. It provides the core object system used in GNOME, the main loop implementation, and a large set of utility functions for strings and common data structures.")
                url.set("https://gitlab.gnome.org/GNOME/glib/")
                licenses {
                    license {
                        name.set("LGPL-2.1-or-later")
                        url.set("https://gitlab.gnome.org/GNOME/glib/-/raw/${portVersion}/COPYING")
                        distribution.set("repo")
                    }
                    license {
                        name.set("LGPL-2.1-or-later")
                        url.set("https://gitlab.gnome.org/GNOME/glib/-/raw/${portVersion}/LICENSES/LGPL-2.1-or-later.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    // Developer list obtained from:
                    // https://gitlab.gnome.org/GNOME/glib/-/raw/2.78.3/docs/CODEOWNERS
                    developer {
                        id.set("pwithnall")
                    }
                    developer {
                        id.set("ebassi")
                    }
                    developer {
                        id.set("3v1n0")
                    }
                    developer {
                        id.set("xclaesse")
                    }
                    developer {
                        id.set("nirbheek")
                    }
                    developer {
                        id.set("creiter")
                    }
                    developer {
                        id.set("jralls")
                    }
                    developer {
                        id.set("sdroege")
                    }
                    developer {
                        id.set("lrn")
                    }
                    developer {
                        id.set("fanc999")
                    }
                    developer {
                        id.set("lb90")
                    }
                    developer {
                        id.set("jmatthew")
                    }
                    developer {
                        id.set("ajacoutot")
                    }
                    developer {
                        id.set("lantw")
                    }
                    developer {
                        id.set("matthiasc")
                    }
                    developer {
                        id.set("alexl")
                    }
                    developer {
                        id.set("mcatanzaro")
                    }
                    developer {
                        id.set("pgriffis")
                    }
                    developer {
                        id.set("smcv")
                    }
                    developer {
                        id.set("oholy")
                    }
                }
                scm {
                    url.set("https://github.com/ViliusSutkus89/ndkports")
                    connection.set("scm:git:https://github.com/ViliusSutkus89/ndkports.git")
                }
            }
        }
    }
}

afterEvaluate {
    System.getenv("SIGNING_KEY")?.let { signingKey ->
        signing {
            isRequired = true
            useInMemoryPgpKeys(signingKey, System.getenv("SIGNING_PASS"))
            sign(publishing.publications.findByName("release"))
        }
    }
}
