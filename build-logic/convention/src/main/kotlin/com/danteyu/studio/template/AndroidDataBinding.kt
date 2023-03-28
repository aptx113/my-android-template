package com.danteyu.studio.template

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureAndroidDataBinding(commonExtension: CommonExtension<*, *, *, *>) {
    commonExtension.apply {
        buildFeatures {
            dataBinding {
                enable = true
            }
        }
    }
}
