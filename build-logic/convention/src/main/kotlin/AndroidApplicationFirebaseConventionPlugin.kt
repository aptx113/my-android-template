import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.danteyu.studio.template.config.LibsConst
import com.danteyu.studio.template.config.LibsConst.LIBS
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.config.implement
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.utils.IMPLEMENTATION

class AndroidApplicationFirebaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
//                apply(PluginsConst.GOOGLE_SERVICES_ID)
                apply(PluginsConst.FIREBASE_PERFORMANCE_ID)
                apply(PluginsConst.FIREBASE_CRASHLYTICS_ID)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named(LIBS)
            dependencies {
                val bom = libs.findLibrary(LibsConst.FIREBASE_BOM).get()
                implement(platform(bom))
                IMPLEMENTATION(libs.findLibrary(LibsConst.FIREBASE_ANALYTICS).get())
                IMPLEMENTATION(libs.findLibrary(LibsConst.FIREBASE_CRASHLYTICS).get())
                IMPLEMENTATION(libs.findLibrary(LibsConst.FIREBASE_PERFORMANCE).get())
            }

            extensions.configure<ApplicationAndroidComponentsExtension> {
                finalizeDsl {
                    it.buildTypes.forEach { buildType ->
                        buildType.configure<CrashlyticsExtension> {
                            // Disable the Crashlytics mapping file upload. This feature should only be
                            // enabled if a Firebase backend is available and configured in
                            // google-services.json.
                            mappingFileUploadEnabled = false
                        }
                    }
                }
            }
        }
    }
}
