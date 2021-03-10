plugins {
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
