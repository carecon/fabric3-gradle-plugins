package org.fabric3.gradle.plugin.core.util;

import org.gradle.api.Project;
import org.gradle.tooling.BuildException;

public class GradleVersionCheck {
    public static void checkGradleVersion(Project project, String gradleMinVersion, String gradlePluginName) {
        String projectGradleVersion = project.getGradle().getGradleVersion();
        if (new VersionComparator().compare(gradleMinVersion, projectGradleVersion) > 0) {
            throw new BuildException(String.format(
                    "Detected Gradle version %s, but %s requires Gradle version %s or higher.",
                    projectGradleVersion, gradlePluginName, gradleMinVersion), null);
        }
    }
}
