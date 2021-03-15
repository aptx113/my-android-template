package plugins

/**
 * Created by George Yu on 2021/3/15.
 *
 * Configuration of all gradle build plugins
 */
object Plugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val HILT_ANDROID = "dagger.hilt.android.plugin"
    const val KOTLIN_ANDROID = "android"
    const val KOTLIN_KAPT = "kapt"
    const val NAV_SAFEARGS = "androidx.navigation.safeargs.kotlin"
}
