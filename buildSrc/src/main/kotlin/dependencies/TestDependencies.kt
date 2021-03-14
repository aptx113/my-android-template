package dependencies

import dependencyVersions.DependencyVersions.ROOM_VERSION
import dependencyVersions.TestDependencyVersions.JUNIT_VERSION

/**
 * Created by George Yu on 2021/3/10.
 *
 * All the Project Test dependencies are declared here.
 * These can be used across the Project
 */
object TestDependencies {
    const val JUNIT = "junit:junit:${JUNIT_VERSION}"
    const val ROOM_TESTING = "androidx.room:room-testing:${ROOM_VERSION}"
}

val testLibraries = arrayListOf<String>().apply {
    add(TestDependencies.JUNIT)
    add(TestDependencies.ROOM_TESTING)
}
