import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
  id("build-kmp")
  alias(libs.plugins.crowdproj.generator)
  alias(libs.plugins.kotlinx.serialization)
}

crowdprojGenerate {
  packageName.set("${project.group}.api.v1")
  inputSpec.set(rootProject.ext["spec-story-v1"] as String)
}

kotlin {
  sourceSets {
    val serializationVersion: String by project
    val commonMain by getting {
      kotlin.srcDirs(layout.buildDirectory.dir("generate-resources/src/commonMain/kotlin"))
      dependencies {
        implementation(kotlin("stdlib-common"))

        implementation(libs.kotlinx.serialization.core)
        implementation(libs.kotlinx.serialization.json)
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
        implementation(project(":ok-social-network-common:ok-social-network-constants"))
      }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit"))
        implementation(project(":ok-social-network-common:ok-social-network-constants"))
      }
    }
  }
}

tasks {
  val openApiGenerateTask: GenerateTask = getByName("openApiGenerate", GenerateTask::class) {
    outputDir.set(layout.buildDirectory.file("generate-resources").get().toString())
    finalizedBy("compileCommonMainKotlinMetadata")
  }
  filter { it.name.startsWith("compile") }.forEach {
    it.dependsOn(openApiGenerateTask)
  }
}
