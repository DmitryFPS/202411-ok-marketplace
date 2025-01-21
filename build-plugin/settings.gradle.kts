rootProject.name = "backend-build"

// Блок `dependencyResolutionManagement` используется для настройки управления зависимостями в Gradle.
// Это позволяет централизованно управлять версиями зависимостей и плагинов.
dependencyResolutionManagement {
    // Блок `versionCatalogs` используется для создания и настройки версионных каталогов.
    versionCatalogs {
        // Создаём версионный каталог с именем "libs".
        // Имя "libs" будет использоваться для доступа к зависимостям в других частях проекта.
        create("libs") {
            // Указываем, что каталог должен быть загружен из файла `libs.versions.toml`,
            // который находится в папке `../gradle` относительно текущего проекта.
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
