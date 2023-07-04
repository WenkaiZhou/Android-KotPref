# Android-KotPref
随时随地像使用变量一样使用`SharedPreference`.

[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0)
[![MavenCentral](https://img.shields.io/badge/%20MavenCentral%20-1.0.0-5bc0de.svg?style=flat-square)](https://repo1.maven.org/maven2/com/zwenkai/kotpref)
[![MinSdk](https://img.shields.io/badge/%20MinSdk%20-%2014%2B%20-f0ad4e.svg?style=flat-square)](https://android-arsenal.com/api?level=14)

## 怎么用

1. 设置`Context`

    ```Kotlin
    KotPref.init(context)
    ```
2. 任意位置使用

    ```Kotlin
    private var count by pref(0)
    var name by pref("")
    var hasShow by pref(false)
    var rate by pref(68.34f)
    var totalCount by pref(0L)
    ```
