// Подключаем плагин `kotlin-dsl`, который позволяет писать кастомные плагины на Kotlin.
// Этот плагин добавляет поддержку Kotlin для написания скриптов Gradle.
plugins {
    `kotlin-dsl`
}

// Блок `gradlePlugin` используется для регистрации кастомных плагинов.
// Здесь мы определяем плагины, которые будут доступны в проекте.
gradlePlugin {
    plugins {
        // Регистрируем плагин с именем "build-jvm".
        register("build-jvm") {
            // Указываем идентификатор плагина, который будет использоваться в plugins
            id = "build-jvm"
            // Указываем класс, который реализует логику плагина.
            implementationClass = "ru.orlov.BuildPluginJvm"
        }
        register("build-kmp") {
            id = "build-kmp"
            implementationClass = "ru.orlov.BuildPluginMultiplatform"
        }

        register("build-lesson-jvm") {
            id = "build-lesson-jvm"
            implementationClass = "ru.orlov.BuildPluginLessonJvm"
        }
        register("build-coroutine-lesson-jvm") {
            id = "build-coroutine-lesson-jvm"
            implementationClass = "ru.orlov.BuildPluginCoroutineLessonJvm"
        }
    }
}

// Настраиваем репозитории, из которых Gradle будет загружать зависимости.
// В данном случае используется Maven Central — один из основных репозиториев для Java/Kotlin библиотек.
repositories {
    mavenCentral()
}

dependencies {
    // что бы в плагинах была доступна сгенерированная конструкция libs.versions.jvm.language.get() - как пример
    // и вот таким способом в плагинах получаем нужные либсы (val libs = project.the<LibrariesForLibs>())
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.binaryCompatibilityValidator)
}
