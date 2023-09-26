pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("testLibs") {
            from(files("gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "task-android"
include(":app")
include(":core:domain")
include(":core:common")
include(":core:ui")
include(":data:local")
