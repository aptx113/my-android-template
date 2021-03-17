import dependencyLibs.AndroidTestDependencies.androidTestLibraries
import dependencyLibs.Libraries.kaptLibraries
import dependencyLibs.Libraries.libraries
import dependencyLibs.TestDependencies.testLibraries
import ext.addAndroidTestDependencies
import ext.addDependencies
import ext.addKapt
import ext.addTestDependencies

plugins {
    id(gradlePlugins.Plugins.ANDROID_APPLICATION)
    kotlin(gradlePlugins.Plugins.KOTLIN_ANDROID)
    kotlin(gradlePlugins.Plugins.KOTLIN_KAPT)
    id(gradlePlugins.Plugins.HILT_ANDROID)
    id(gradlePlugins.Plugins.NAV_SAFEARGS)
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

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }

        getByName(BuildType.DEBUG) {
            applicationIdSuffix = BuildTypeDebug.APPLICATION_ID_SUFFIX
            versionNameSuffix = BuildTypeDebug.VERSION_NAME_SUFFIX
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
        }
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)

    productFlavors {
        create("dev") {
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            dimension = BuildProductDimensions.ENVIRONMENT
        }

        create("qa") {
            applicationIdSuffix = ".qa"
            versionNameSuffix = "-qa"
            dimension = BuildProductDimensions.ENVIRONMENT
        }

        create("prod") {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    addDependencies(libraries)
    addKapt(kaptLibraries)
    addTestDependencies(testLibraries)
    addAndroidTestDependencies(androidTestLibraries)
}
