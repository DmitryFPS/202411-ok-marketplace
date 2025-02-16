package docker

import fixture.docker.AbstractDockerCompose

/**
 * Объект, представляющий Docker Compose конфигурацию для Wiremock.
 * Наследуется от [AbstractDockerCompose] и предоставляет предварительно настроенную конфигурацию
 * для запуска Wiremock в Docker Compose.
 *
 * Использует следующие параметры:
 * - Сервис: `app-wiremock_1`
 * - Порт: `8080`
 * - Docker Compose файл: `docker-compose-wiremock.yml`
 *
 * Этот объект упрощает запуск и управление Wiremock в Docker Compose, предоставляя
 * готовую конфигурацию для тестирования или разработки.
 */
object WiremockDockerCompose : AbstractDockerCompose(
    "app-wiremock_1", 8080, "docker-compose-wiremock.yml"
)
