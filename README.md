# ndkports

A collection of Android build scripts for various open source libraries and the
tooling to build them.

Buildscripts are based on Google's [ndkports](https://android.googlesource.com/platform/tools/ndkports/).

Compiled binaries are (will be) distributed through MavenCentral.

## Matrix

Each port is built on a matrix of NDK versions and library type.

- com.viliussutkus89.ndk.thirdparty:libfoo-ndk26-static:0.4.1
- com.viliussutkus89.ndk.thirdparty:libfoo-ndk26-shared:0.4.1
- com.viliussutkus89.ndk.thirdparty:libfoo-ndk25-static:0.4.1
- com.viliussutkus89.ndk.thirdparty:libfoo-ndk25-shared:0.4.1

#### Min SDK Version:

Builds compiled with NDK-26 support Android SDK 21 (Lollipop) and later.

Builds compiled with NDK-25 support Android SDK 19 (KitKat) and later.

Libraries built with different NDK versions should not be used in the same application.

#### Libraries are built as:

- static (libfoo.a) with static dependencies
- shared (libfoo.so) with static dependencies

## TODO

Run unit tests provided by upstream packages.

Figure out proper way to deliver per ABI headers.

## Ports

#### [GNU FriBidi](https://github.com/fribidi/fribidi)

[![fribidi](https://github.com/ViliusSutkus89/ndkports/actions/workflows/fribidi.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/fribidi.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/fribidi-ndk25-static.svg?label=Maven%20Central%20fribidi-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:fribidi-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/fribidi-ndk25-shared.svg?label=Maven%20Central%20fribidi-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:fribidi-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/fribidi-ndk26-static.svg?label=Maven%20Central%20fribidi-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:fribidi-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/fribidi-ndk26-shared.svg?label=Maven%20Central%20fribidi-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:fribidi-ndk26-shared)

#### [libpng](http://libpng.org/pub/png/libpng.html)

[![libpng](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libpng.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libpng.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libpng-ndk25-static.svg?label=Maven%20Central%20libpng-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libpng-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libpng-ndk25-shared.svg?label=Maven%20Central%20libpng-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libpng-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libpng-ndk26-static.svg?label=Maven%20Central%20libpng-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libpng-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libpng-ndk26-shared.svg?label=Maven%20Central%20libpng-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libpng-ndk26-shared)

#### [FreeType](https://freetype.org)

[![freetype](https://github.com/ViliusSutkus89/ndkports/actions/workflows/freetype.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/freetype.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/freetype-ndk25-static.svg?label=Maven%20Central%20freetype-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:freetype-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/freetype-ndk25-shared.svg?label=Maven%20Central%20freetype-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:freetype-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/freetype-ndk26-static.svg?label=Maven%20Central%20freetype-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:freetype-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/freetype-ndk26-shared.svg?label=Maven%20Central%20freetype-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:freetype-ndk26-shared)

#### [PCRE2 - Perl-Compatible Regular Expressions](https://github.com/PCRE2Project/pcre2)

[![pcre2](https://github.com/ViliusSutkus89/ndkports/actions/workflows/pcre2.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/pcre2.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/pcre2-ndk25-static.svg?label=Maven%20Central%20pcre2-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:pcre2-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/pcre2-ndk25-shared.svg?label=Maven%20Central%20pcre2-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:pcre2-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/pcre2-ndk26-static.svg?label=Maven%20Central%20pcre2-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:pcre2-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/pcre2-ndk26-shared.svg?label=Maven%20Central%20pcre2-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:pcre2-ndk26-shared)

#### [libjpeg-turbo](https://libjpeg-turbo.org)

[![libjpeg-turbo](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libjpeg-turbo.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libjpeg-turbo.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libjpeg-turbo-ndk25-static.svg?label=Maven%20Central%20libjpeg-turbo-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libjpeg-turbo-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libjpeg-turbo-ndk25-shared.svg?label=Maven%20Central%20libjpeg-turbo-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libjpeg-turbo-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libjpeg-turbo-ndk26-static.svg?label=Maven%20Central%20libjpeg-turbo-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libjpeg-turbo-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libjpeg-turbo-ndk26-shared.svg?label=Maven%20Central%20libjpeg-turbo-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libjpeg-turbo-ndk26-shared)

#### [libffi](https://sourceware.org/libffi/)

[![libffi](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libffi.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libffi.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libffi-ndk25-static.svg?label=Maven%20Central%20libffi-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libffi-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libffi-ndk25-shared.svg?label=Maven%20Central%20libffi-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libffi-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libffi-ndk26-static.svg?label=Maven%20Central%20libffi-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libffi-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libffi-ndk26-shared.svg?label=Maven%20Central%20libffi-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libffi-ndk26-shared)

#### [LibTIFF](http://www.simplesystems.org/libtiff/)

[![libtiff](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libtiff.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libtiff.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libtiff-ndk25-static.svg?label=Maven%20Central%20libtiff-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libtiff-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libtiff-ndk25-shared.svg?label=Maven%20Central%20libtiff-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libtiff-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libtiff-ndk26-static.svg?label=Maven%20Central%20libtiff-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libtiff-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libtiff-ndk26-shared.svg?label=Maven%20Central%20libtiff-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libtiff-ndk26-shared)

#### [Expat](https://github.com/libexpat/libexpat)

[![libexpat](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libexpat.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/libexpat.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libexpat-ndk25-static.svg?label=Maven%20Central%20libexpat-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libexpat-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libexpat-ndk25-shared.svg?label=Maven%20Central%20libexpat-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libexpat-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libexpat-ndk26-static.svg?label=Maven%20Central%20libexpat-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libexpat-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/libexpat-ndk26-shared.svg?label=Maven%20Central%20libexpat-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:libexpat-ndk26-shared)

#### [Little CMS color engine](https://www.littlecms.com/color-engine/)

[![lcms2](https://github.com/ViliusSutkus89/ndkports/actions/workflows/lcms2.yml/badge.svg)](https://github.com/ViliusSutkus89/ndkports/actions/workflows/lcms2.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/lcms2-ndk25-static.svg?label=Maven%20Central%20lcms2-ndk25-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:lcms2-ndk25-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/lcms2-ndk25-shared.svg?label=Maven%20Central%20lcms2-ndk25-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:lcms2-ndk25-shared)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/lcms2-ndk26-static.svg?label=Maven%20Central%20lcms2-ndk26-static)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:lcms2-ndk26-static)
[![Maven Central](https://img.shields.io/maven-central/v/com.viliussutkus89.ndk.thirdparty/lcms2-ndk26-shared.svg?label=Maven%20Central%20lcms2-ndk26-shared)](https://search.maven.org/search?q=g:com.viliussutkus89.ndk.thirdparty%20AND%20a:lcms2-ndk26-shared)
