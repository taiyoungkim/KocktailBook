plugins {
    `kotlin-dsl`
}

group = "com.tydev.kocktailbook.plugins"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    compileOnly(libs.android.gradle.tools)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "kocktailbook.application"
            implementationClass = "ApplicationPlugin"
        }
        register("androidLibrary") {
            id = "kocktailbook.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidComposeLibrary") {
            id = "kocktailbook.compose.library"
            implementationClass = "ComposeLibraryPlugin"
        }
        register("androidFeature") {
            id = "kocktailbook.android.feature"
            implementationClass = "FeaturePlugin"
        }
        register("kmmDomain") {
            id = "kocktailbook.kmm.domain"
            implementationClass = "KotlinMultiplatformDomainPlugin"
        }
        register("kmmLibrary") {
            id = "kocktailbook.kmm.library"
            implementationClass = "KotlinMultiplatformLibraryPlugin"
        }
    }
}
