import dependencyLibs.TestDependencies.JUNIT

plugins {
    id(gradlePlugins.Plugins.JAVA_LIBRARY)
    id(gradlePlugins.Plugins.KOTLIN)
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
    implementation(dependencyLibs.Kotlin.stdlib)
    testImplementation(JUNIT)
}
