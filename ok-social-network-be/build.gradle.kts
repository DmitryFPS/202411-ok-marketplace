plugins {
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
}

group = "ru.otus.orlov.social_network_be"
version = "1.0-SNAPSHOT"

allprojects {
  repositories {
    mavenCentral()
  }
}

ext {
  val specDir = layout.projectDirectory.dir("../specs")
  set("spec-story-v1", specDir.file("specs-story-v1.yaml").toString())
}

subprojects {
  group = rootProject.group
  version = rootProject.version
}
