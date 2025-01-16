package ru.orlov

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.repositories

internal class BuildPluginCoroutineLessonJvm : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        // Применяем плагин Kotlin JVM
        // Это эквивалентно plugins { kotlin("jvm") }
        pluginManager.apply("org.jetbrains.kotlin.jvm")

        // Устанавливаем группу и версию из rootProject
        group = rootProject.group
        version = rootProject.version

        // Добавляем зависимости
        dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-stdlib")
        dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
        dependencies.add("implementation", "com.squareup.okhttp3:okhttp:4.12.0") // HTTP-клиент
        dependencies.add("implementation", "com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2") // JSON-парсер

        // Тестирование
        dependencies.add("testImplementation", "org.jetbrains.kotlin:kotlin-test-junit")

        // Настраиваем репозитории
        repositories {
            mavenCentral()
        }
    }
}
