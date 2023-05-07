package com.tydev.kocktailbook

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform