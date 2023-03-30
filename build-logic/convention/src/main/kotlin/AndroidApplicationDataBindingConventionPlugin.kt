import com.android.build.api.dsl.ApplicationExtension
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.configureAndroidDataBinding
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationDataBindingConventionPlugin:Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            pluginManager.apply(PluginsConst.ANDROID_APPLICATION_ID)
            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidDataBinding(extension)
        }
    }
}
