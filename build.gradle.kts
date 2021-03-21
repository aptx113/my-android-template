/*
 * Copyright 2021 Dante
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
        classpath(dependencyLibs.Hilt.HILT_GRADLE)
        classpath(dependencyLibs.Navigation.SAFE_ARGS_GRADLE)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id(Plugins.GRADLE_VERSIONS_PLUGIN) version PluginVersions.GRADLE_VER_PLUGIN_VERSION
    id(Plugins.DETEKT) version PluginVersions.DETEKT_VERSION
    id(Plugins.KTLINT) version PluginVersions.KTLINT_VERSION
    id(Plugins.SPOTLESS) version PluginVersions.SPOTLESS_VERSION
}

allprojects {
    repositories.applyDefault()

    apply {
        plugin(Plugins.DETEKT)
        plugin(Plugins.KTLINT)
        plugin(Plugins.SPOTLESS)
    }

    detekt {
        config = rootProject.files("$rootDir/.detekt/config.yml")
        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt/report.html")
            }
        }
    }

    ktlint {
        debug.set(false)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

    @Suppress("INACCESSIBLE_TYPE")
    spotless {
        format("misc") {
            target(
                fileTree(
                    mapOf(
                        "dir" to ".",
                        "include" to listOf("**/*.md", "**/.gitignore", "**/*.yaml", "**/*.yml"),
                        "exclude" to listOf(
                            ".gradle/**",
                            ".gradle-cache/**",
                            "**/tools/**",
                            "**/build/**"
                        )
                    )
                )
            )
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        format("xml") {
            target(
                fileTree(
                    mapOf(
                        "dir" to ".",
                        "include" to listOf("**/res/**/*.xml"),
                        "exclude" to listOf("**/build/**/*.xml")
                    )
                )
            )
            indentWithSpaces(4)
            trimTrailingWhitespace()
            endWithNewline()
        }

        kotlin {
            target(
                fileTree(
                    mapOf(
                        "dir" to ".",
                        "include" to listOf("**/*.kt"),
                        "exclude" to listOf("**/build/**", "**/buildSrc/**", "**/.*")
                    )
                )
            )
            licenseHeaderFile(
                rootProject.file(".spotless/copyright.kt"),
                "^(package|object|import|interface)"
            )
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        kotlinGradle {
            target(
                fileTree(
                    mapOf(
                        "dir" to ".",
                        "include" to listOf("**/*.gradle.kts", "*.gradle.kts"),
                        "exclude" to listOf("**/build/**")
                    )
                )
            )
            licenseHeaderFile(
                rootProject.file(".spotless/copyright.kt"),
                "package|import|tasks|apply|plugins|pluginManagement|include|val|object|interface"
            )
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
    }
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
