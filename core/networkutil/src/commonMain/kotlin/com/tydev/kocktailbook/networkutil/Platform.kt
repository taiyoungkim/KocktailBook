package com.tydev.kocktailbook.networkutil

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform