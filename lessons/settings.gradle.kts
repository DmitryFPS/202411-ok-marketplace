rootProject.name = "lessons"

// Тут резолвим путь ../gradle/libs.versions.toml что бы можно было использовать libs
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    // Включаем в сборку мобуль build-plugin со своими плагинами
    includeBuild("../build-plugin")

    plugins {
        // Это для примера, что так тоже можно брать данные из gradle.properties
        // Но можно и так id("build-jvm") apply false (Теперь есть свой плагин)
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
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

include("m1l1-first")
include("m1l2-basic")
include("m1l3-func")
include("m1l4-oop")
include("m2l1-dsl")
include("m2l2-coroutines")
include("m2l3-flows")
include("m2l4-kmp")
include("m2l5-1-interop")
include("m2l5-2-jni")
include("m2l6-gradle")
