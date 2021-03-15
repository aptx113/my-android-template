package ext

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created by George Yu on 2021/3/14.
 *
 * util functions for adding the different type dependencies from build.gradle file
 */
fun DependencyHandler.kapt(dependencies: List<String>) {
    dependencies.forEach { add("kapt", it) }
}

fun DependencyHandler.implementation(dependencies: List<String>) {
    dependencies.forEach { add("implementation", it) }
}

fun DependencyHandler.androidTestImplementation(dependencies: List<String>) {
    dependencies.forEach { add("androidTestImplementation", it) }
}

fun DependencyHandler.testImplementation(dependencies: List<String>) {
    dependencies.forEach { add("testImplementation", it) }
}
