package com.tydev.kocktailbook.database

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform