import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import ext.applyDefault

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(dependencyLibs.AndroidGradle.GRADLE)
        classpath(dependencyLibs.Hilt.HILT_GRADLE)
        classpath(dependencyLibs.Kotlin.KOTLIN_GRADLE)
        classpath(dependencyLibs.Navigation.SAFE_ARGS_GRADLE)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id(gradlePlugins.Plugins.GRADLE_VERSIONS_PLUGIN) version gradlePlugins.PluginVersions.GRADLE_VER_PLUGIN_VERSION
}

allprojects {
    repositories.applyDefault()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean =
    listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea")
        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-+]*") }
        .any { it.matches(version) }
