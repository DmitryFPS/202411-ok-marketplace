plugins {
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("ru.otus.orlov.social_network_be:ok-social-network-api-v1-story")
  implementation("ru.otus.orlov.social_network_be:ok-social-network-constants")

  testImplementation(libs.logback)
  testImplementation(libs.kermit)

  testImplementation(libs.bundles.kotest)

  testImplementation(libs.testcontainers.core)
  testImplementation(libs.coroutines.core)

  testImplementation(libs.ktor.client.core)
  testImplementation(libs.ktor.client.okhttp)
}

tasks {
  withType<Test>().configureEach {
    useJUnitPlatform()
  }
}
