package commons

import dependencyLibs.Kotlin
import dependencyLibs.TestDependencies
import gradle.kotlin.dsl.accessors._c1423b320eb21bea40af7b76d5a93e57.implementation
import gradle.kotlin.dsl.accessors._c1423b320eb21bea40af7b76d5a93e57.testImplementation

plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(Kotlin.stdlib)

    testImplementation(TestDependencies.JUNIT)
}
