rootProject.name = "ok-social-network"

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

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

// Включает вот такую конструкцию
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":ok-social-network-tmp")
include(":ok-social-network-front")
include(":ok-social-network-entity:ok-social-network-story")
include(":ok-social-network-api:ok-social-network-api-v1-story")
include(":ok-social-network-mappers:ok-social-network-api-v1-story-mappers")
include(":ok-social-network-common:ok-social-network-constants")
