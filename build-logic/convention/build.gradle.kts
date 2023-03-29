plugins {
    `kotlin-dsl`
}

group = "com.danteyu.studio.template.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.firebase.performance.gradle)
    compileOnly(libs.firebase.crashlytics.gradle)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.navigation.safe.args.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "app.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "app.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationDataBinding") {
            id = "app.android.application.databinding"
            implementationClass = "AndroidApplicationDataBindingConventionPlugin"
        }
        register("androidApplicationNavigation") {
            id = "app.android.application.navigation"
            implementationClass = "AndroidApplicationNavigationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "app.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "app.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "app.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryDataBinding") {
            id = "app.android.library.databinding"
            implementationClass = "AndroidLibraryDataBindingConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "app.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidFeature") {
            id = "app.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidTest") {
            id = "app.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "app.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "app.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidFirebase") {
            id = "app.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidFlavors") {
            id = "app.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
    }
}
