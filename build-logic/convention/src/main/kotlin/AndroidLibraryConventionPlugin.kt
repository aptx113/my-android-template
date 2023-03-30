import com.android.build.gradle.LibraryExtension
import com.danteyu.studio.template.config.DefaultConfigs.TARGET_SDK
import com.danteyu.studio.template.config.LibsConst
import com.danteyu.studio.template.config.LibsConst.LIBS
import com.danteyu.studio.template.config.LibsConst.TEST
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.config.implementAndroidTest
import com.danteyu.studio.template.config.implementTest
import com.danteyu.studio.template.configureFlavors
import com.danteyu.studio.template.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(PluginsConst.ANDROID_LIBRARY_ID)
                apply(PluginsConst.KOTLIN_ANDROID_ID)
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = TARGET_SDK
                configureFlavors(this)
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named(LIBS)
            configurations.configureEach {
                resolutionStrategy {
                    force(libs.findLibrary(LibsConst.JUNIT4).get())
                }
            }
            dependencies {
                implementAndroidTest(kotlin(TEST))
                implementTest(kotlin(TEST))
            }
        }
    }
}
