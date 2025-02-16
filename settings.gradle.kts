rootProject.name = "ok-marketplace-202411"

pluginManagement {
  plugins {
    val kotlinVersion: String by settings
    kotlin("jvm") version kotlinVersion
  }
}

// Официальный плагин Gradle, который упрощает управление Toolchains (инструментальными цепочками) для JDK.
// Он интегрируется с сервисом Foojay (сокращение от "For OpenJDK"),
// который предоставляет удобный доступ к различным версиям OpenJDK
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

//includeBuild("lessons")
includeBuild("ok-social-network-be")
includeBuild("ok-social-network-tests")
