
plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    google()
    gradlePluginPortal()
    jcenter()
    mavenCentral()
}
