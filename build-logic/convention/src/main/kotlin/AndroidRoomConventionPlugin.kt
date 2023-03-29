import com.danteyu.studio.template.config.LibsConst
import com.danteyu.studio.template.config.LibsConst.LIBS
import com.danteyu.studio.template.config.PluginsConst
import com.danteyu.studio.template.config.addKsp
import com.danteyu.studio.template.config.implement
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.process.CommandLineArgumentProvider
import java.io.File

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(PluginsConst.KSP_PLUGIN_ID)

            extensions.configure<KspExtension> {
                arg(RoomSchemaArgProvider(File(projectDir,"schemas")))
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named(LIBS)
            dependencies {
                implement(libs.findLibrary(LibsConst.ROOM_RUNTIME).get())
                implement(libs.findLibrary(LibsConst.ROOM_KTX).get())
                addKsp(libs.findLibrary(LibsConst.ROOM_COMPILER).get())
            }
        }
    }

    class RoomSchemaArgProvider(
        @get:InputDirectory
        @get:PathSensitive(PathSensitivity.RELATIVE)
        val schemaDir: File
    ):CommandLineArgumentProvider{
        override fun asArguments() = listOf("room.schemaLocation=${schemaDir.path}")
    }
}
