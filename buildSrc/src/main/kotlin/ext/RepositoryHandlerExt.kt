package ext

import org.gradle.api.artifacts.dsl.RepositoryHandler

/**
 * Created by George Yu on 2021/3/14.
 *
 * Adds all default repositories used to access the different declared dependencies
 */
fun RepositoryHandler.applyDefault() {
    google()
    mavenCentral()
    jcenter()
}
