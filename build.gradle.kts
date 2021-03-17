import ext.applyDefault

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(dependencyLibs.AndroidGradle.GRADLE)
        classpath(dependencyLibs.Hilt.HILT_GRADLE)
        classpath(dependencyLibs.Kotlin.KOTLIN_GRADLE)
        classpath(dependencyLibs.Navigation.SAFE_ARGS_GRADLE)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories.applyDefault()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
