plugins {
  id("build-jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
  implementation(kotlin("stdlib"))

  implementation(project(":ok-social-network-entity:ok-social-network-story"))
  implementation(project(":ok-social-network-api:ok-social-network-api-v1-story"))
  implementation(project(":ok-social-network-common:ok-social-network-constants"))

  testImplementation(kotlin("test-junit"))
}
