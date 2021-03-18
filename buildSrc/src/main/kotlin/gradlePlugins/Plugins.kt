package gradlePlugins

/**
 * Created by George Yu on 2021/3/15.
 *
 * Configuration of all gradle build plugins
 */
object Plugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"

    const val JAVA_LIBRARY = "java-library"

    const val KOTLIN = "kotlin"
    const val HILT_ANDROID = "dagger.hilt.android.plugin"
    const val KOTLIN_ANDROID = "android"
    const val KOTLIN_KAPT = "kapt"
    const val NAV_SAFEARGS = "androidx.navigation.safeargs.kotlin"

    const val GRADLE_VERSIONS_PLUGIN = "com.github.ben-manes.versions"
    const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
}