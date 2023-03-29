import com.danteyu.studio.template.config.LibsConst
import com.danteyu.studio.template.config.LibsConst.IMPLEMENTATION
import com.danteyu.studio.template.config.LibsConst.KAPT
import com.danteyu.studio.template.config.LibsConst.KAPT_ANDROID_TEST
import com.danteyu.studio.template.config.LibsConst.LIBS
import com.danteyu.studio.template.config.PluginsConst
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(PluginsConst.HILT_PLUGIN_ID)
                apply(PluginsConst.KAPT_PLUGIN_ID)
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named(LIBS)
            dependencies {
                IMPLEMENTATION(libs.findLibrary(LibsConst.HILT_ANDROID).get())
                KAPT(libs.findLibrary(LibsConst.HILt_COMPILER).get())
                KAPT_ANDROID_TEST(libs.findLibrary(LibsConst.HILt_COMPILER).get())
            }
        }
    }
}
