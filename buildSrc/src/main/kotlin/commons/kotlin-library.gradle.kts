/*
 * Copyright 2021 Dante Yu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
