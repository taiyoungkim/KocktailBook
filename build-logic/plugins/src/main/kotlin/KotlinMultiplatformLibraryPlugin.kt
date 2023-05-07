import com.android.build.gradle.LibraryExtension
import com.tydev.kocktailbook.extensions.configureFlavors
import com.tydev.kocktailbook.extensions.configureKotlinMultiplatform
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class KotlinMultiplatformLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinMultiplatform(this)
                defaultConfig.targetSdk = 33
                configureFlavors(this)
            }

        }
    }
}