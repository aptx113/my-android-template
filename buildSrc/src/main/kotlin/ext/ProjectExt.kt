package ext

import org.gradle.api.Project
import utils.BuildUtils.getLocalProperty

/**
 * Created by George Yu on 2021/3/14.
 *
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String = getLocalProperty(propertyName, this)