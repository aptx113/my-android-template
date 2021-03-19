package commons

import BuildType
import dependencyLibs.Kotlin
import dependencyLibs.TestDependencies
import dependencyLibs.AndroidTestDependencies

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFile("consumer-rules.pro")
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
            versionNameSuffix = BuildTypeDebug.VERSION_NAME_SUFFIX
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
        }
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorDevelop.libraryCreate(this)
        ProductFlavorQA.libraryCreate(this)
        ProductFlavorProduction.libraryCreate(this)
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

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    dependencies {
        implementation(Kotlin.stdlib)

        testImplementation(TestDependencies.JUNIT)

        androidTestImplementation(AndroidTestDependencies.ESPRESSO_CORE)
        androidTestImplementation(AndroidTestDependencies.TEST_EXT_JUNIT)
    }
}
