import dependencies.Gradle.GRADLE
import dependencies.Hilt.HILT_GRADLE
import dependencies.Kotlin.KOTLIN_GRADLE
import dependencies.Navigation.SAFE_ARGS_GRADLE
import ext.applyDefault

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories.applyDefault()

    dependencies {
        classpath(GRADLE)
        classpath(HILT_GRADLE)
        classpath(KOTLIN_GRADLE)
        classpath(SAFE_ARGS_GRADLE)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories.applyDefault()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
