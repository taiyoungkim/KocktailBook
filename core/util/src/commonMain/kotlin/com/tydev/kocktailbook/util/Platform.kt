package com.tydev.kocktailbook.util

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform