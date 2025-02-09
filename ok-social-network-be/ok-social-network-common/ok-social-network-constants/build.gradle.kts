plugins {
  id("build-kmp")
  alias(libs.plugins.kotlinx.serialization)
}

kotlin {
  sourceSets {
    val coroutinesVersion: String by project
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))
        api(libs.kotlinx.datetime)
        implementation(libs.kotlinx.serialization.core)
        implementation(libs.kotlinx.serialization.json)
      }
    }
  }
}
