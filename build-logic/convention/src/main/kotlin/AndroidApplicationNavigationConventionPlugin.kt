import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.config.PluginsConst.NAVIGATION_SAFE_ARGS_PLUGIN_ID
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationNavigationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(PluginsConst.ANDROID_APPLICATION_ID)
                apply(NAVIGATION_SAFE_ARGS_PLUGIN_ID)
            }
        }
    }
}
