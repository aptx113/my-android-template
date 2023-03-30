import com.android.build.api.dsl.LibraryExtension
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.configureAndroidDataBinding
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryDataBindingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(PluginsConst.ANDROID_LIBRARY_ID)
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidDataBinding(extension)
        }
    }
}
