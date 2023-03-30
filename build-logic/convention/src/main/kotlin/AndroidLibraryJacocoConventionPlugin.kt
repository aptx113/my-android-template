import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryJacocoConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(PluginsConst.JACOCO_ID)
                apply(PluginsConst.ANDROID_LIBRARY_ID)
            }
            val extension = extensions.getByType<LibraryAndroidComponentsExtension>()
            configureJacoco(extension)
        }
    }
}
