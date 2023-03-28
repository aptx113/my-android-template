package com.danteyu.studio.template

import com.android.build.api.dsl.CommonExtension
import com.danteyu.studio.template.config.LibsConst
import com.danteyu.studio.template.config.LibsConst.LIBS
import com.danteyu.studio.template.config.VersionsConst
import com.danteyu.studio.template.config.implement
import com.danteyu.studio.template.config.implementAndroidTest
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *>) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named(LIBS)

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion(VersionsConst.ANDROIDX_COMPOSE_COMPILER).get().toString()
        }

        dependencies {
            val bom = libs.findLibrary(LibsConst.ANDROIDX_COMPOSE_BOM).get()
            implement(platform(bom))
            implementAndroidTest(platform(bom))
        }
    }
}
