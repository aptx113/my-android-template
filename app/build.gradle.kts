import dependencyLibs.AndroidTestDependencies.androidTestLibraries
import dependencyLibs.Libraries.kaptLibraries
import dependencyLibs.Libraries.libraries
import dependencyLibs.TestDependencies.testLibraries
import ext.androidTestImplementation
import ext.implementation
import ext.kapt
import ext.testImplementation

plugins {
    id(plugins.Plugins.ANDROID_APPLICATION)
    kotlin(plugins.Plugins.KOTLIN_ANDROID)
    kotlin(plugins.Plugins.KOTLIN_KAPT)
    id(plugins.Plugins.HILT_ANDROID)
    id(plugins.Plugins.NAV_SAFEARGS)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildFeatures {
        dataBinding = BuildFeatures.DATA_BINDING_ENABLED
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libraries)
    kapt(kaptLibraries)
    testImplementation(testLibraries)
    androidTestImplementation(androidTestLibraries)
}
