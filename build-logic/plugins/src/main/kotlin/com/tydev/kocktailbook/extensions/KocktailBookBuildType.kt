package com.tydev.kocktailbook.extensions

enum class KocktailBookBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}