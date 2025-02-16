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
        implementation(project(":ok-social-network-api:ok-social-network-api-v1-story"))
        implementation(project(":ok-social-network-common:ok-social-network-constants"))
      }
    }
    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    jvmTest {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    nativeTest {
      dependencies {
        implementation(kotlin("test"))
      }
    }
  }
}
