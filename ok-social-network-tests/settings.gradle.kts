rootProject.name = "ok-marketplace-tests"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    includeBuild("../build-plugin")
    plugins {
        id("build-jvm") apply false
        id("build-kmp") apply false
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Официальный плагин Gradle, который упрощает управление Toolchains (инструментальными цепочками) для JDK.
// Он интегрируется с сервисом Foojay (сокращение от "For OpenJDK"),
// который предоставляет удобный доступ к различным версиям OpenJDK
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include(":ok-marketplace-e2e-be")
