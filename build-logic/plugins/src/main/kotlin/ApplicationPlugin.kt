import com.android.build.api.dsl.ApplicationExtension
import com.tydev.kocktailbook.extensions.KocktailBookFlavor
import com.tydev.kocktailbook.extensions.configureAndroidCompose
import com.tydev.kocktailbook.extensions.configureFlavors
import com.tydev.kocktailbook.extensions.configureKotlinAndroid
import com.tydev.kocktailbook.extensions.FlavorDimension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("UnstableApiUsage")
class ApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = 33
                    missingDimensionStrategy(FlavorDimension.contentType.name, KocktailBookFlavor.demo.name)
                }

                buildFeatures {
                    buildConfig = true
                }

                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                configureFlavors(this)
            }
        }
    }
}
