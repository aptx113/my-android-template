import com.danteyu.studio.template.AppBuildType
import com.danteyu.studio.template.config.DefaultConfigs
import com.google.protobuf.gradle.builtins
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("app.android.application")
    id("app.android.application.compose")
    id("app.android.application.flavors")
    id("app.android.application.jacoco")
    id("app.android.hilt")
    id("jacoco")
    id("app.android.application.firebase")
    id("app.android.application.navigation")
    id("app.android.application.databinding")
    id("app.android.room")
    id("com.google.protobuf")
}

android {
    defaultConfig {
        applicationId = DefaultConfigs.APPLICATION_ID
        versionCode = DefaultConfigs.VERSION_CODE
        versionName = DefaultConfigs.VERSION_NAME
        testInstrumentationRunner = DefaultConfigs.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = AppBuildType.Debug.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = AppBuildType.Release.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = DefaultConfigs.NAME_SPACE
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val java by registering {
                    option("lite")
                }
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    // Activity
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.activity.ktx)

    implementation(libs.androidx.appcompat)
    // Compose
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.tracing)
    androidTestImplementation(libs.androidx.compose.ui.test)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.util)

    implementation(libs.androidx.constaintlayout)
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    // DataStore
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
    // Fragment
    implementation(libs.androidx.fragment.fragment)
    debugImplementation(libs.androidx.fragment.testing)
    // Lifecycle
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.viewModel.ktx)
    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.fragment)
    androidTestImplementation(libs.androidx.navigation.testing)
    implementation(libs.androidx.navigation.ui)

    implementation(libs.androidx.paging)

    implementation(libs.androidx.recyclerview)

    implementation(libs.androidx.startup)
    // Test
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.ext.truth)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.uiautomator)
    // Work
    implementation(libs.androidx.work.ktx)
    androidTestImplementation(libs.androidx.work.testing)
    // Coil
    implementation(libs.coil.kt.bom)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.svg)
    // Hilt ext
    kapt(libs.hilt.ext.compiler)
    implementation(libs.hilt.ext.work)
    // Kotlin
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.material)

    implementation(libs.okhttp.logging)

    implementation(libs.protobuf.kotlin.lite)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    testImplementation(libs.truth)

    testImplementation(libs.turbine)

    implementation(libs.xLog)
}

kapt {
    correctErrorTypes = true
}
