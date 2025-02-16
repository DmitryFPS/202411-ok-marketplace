plugins {
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
}

group = "ru.otus.orlov.social_network_entity"
version = "1.0-SNAPSHOT"

allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  group = rootProject.group
  version = rootProject.version
}
