import com.android.build.gradle.TestExtension
import com.danteyu.studio.template.config.DefaultConfigs.TARGET_SDK
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(PluginsConst.ANDROID_TEST_ID)
                apply(PluginsConst.KOTLIN_ANDROID_ID)
            }
            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = TARGET_SDK
            }
        }
    }
}
