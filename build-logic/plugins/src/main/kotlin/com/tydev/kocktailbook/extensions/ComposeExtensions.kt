package com.tydev.kocktailbook.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {

        defaultConfig {
            minSdk = 23
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composecompiler").get().toString()
        }

        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs
        }

        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()

            add("implementation", platform(bom))
            add("lintChecks", libs.findLibrary("lint-compose").get())
        }
    }
}
