package fixture.docker

import co.touchlab.kermit.Logger
import io.ktor.http.*
import org.testcontainers.containers.DockerComposeContainer
import java.io.File

private val log = Logger

/**
 * Абстрактный класс для управления Docker Compose контейнерами.
 * Предоставляет базовую функциональность для запуска, остановки и очистки Docker Compose контейнеров,
 * а также для получения URL-адресов сервисов, запущенных в контейнерах.
 *
 * @property apps Список приложений (сервисов) с информацией о сервисе и порте.
 * @property dockerComposeName Имя Docker Compose файла, который будет использоваться для запуска контейнеров.
 */
abstract class AbstractDockerCompose(
  private val apps: List<AppInfo>,
  private val dockerComposeName: String
) : DockerCompose {

  /**
   * Вторичный конструктор для создания экземпляра с одним сервисом.
   *
   * @param service Имя сервиса.
   * @param port Порт, на котором будет доступен сервис.
   * @param dockerComposeName Имя Docker Compose файла.
   */
  constructor(service: String, port: Int, dockerComposeName: String)
    : this(listOf(AppInfo(service, port)), dockerComposeName)

  /**
   * Получает файл Docker Compose по имени.
   *
   * @return Файл Docker Compose.
   * @throws IllegalArgumentException если файл не найден.
   */
  private fun getComposeFile(): File {
    val file = File("docker-compose/$dockerComposeName")
    if (!file.exists()) throw IllegalArgumentException("file $dockerComposeName not found!")
    return file
  }

  /** Docker Compose контейнер, инициализированный на основе файла и списка сервисов. */
  private val compose =
    DockerComposeContainer(getComposeFile()).apply {
      apps.forEach { (service, port) ->
        withExposedService(
          service,
          port,
        )
      }
    }

  /**
   * Запускает Docker Compose контейнеры.
   * В случае ошибки логирует сообщение и выбрасывает исключение.
   */
  override fun start() {
    kotlin.runCatching { compose.start() }.onFailure {
      log.e { "Failed to start $dockerComposeName" }
      throw it
    }

    log.w("\n=========== $dockerComposeName started =========== \n")
    apps.forEachIndexed { index, _ ->
      log.i { "Started docker-compose with App at: ${getUrl(index)}" }
    }
  }

  /** Останавливает Docker Compose контейнеры. */
  override fun stop() {
    compose.close()
    log.w("\n=========== $dockerComposeName complete =========== \n")
  }

  /** Очищает базу данных (заглушка, реализация отсутствует). */
  override fun clearDb() {
    log.w("===== clearDb =====")
    // TODO сделать очистку БД, когда до этого дойдет
  }

  /** Возвращает URL-адрес для первого сервиса в списке. */
  override val inputUrl: URLBuilder
    get() = getUrl(0)

  /**
   * Возвращает URL-адрес для указанного сервиса в списке.
   *
   * @param no Индекс сервиса в списке.
   * @return URL-адрес сервиса.
   */
  private fun getUrl(no: Int) = URLBuilder(
    protocol = URLProtocol.HTTP,
    host = apps[no].let { compose.getServiceHost(it.service, it.port) },
    port = apps[no].let { compose.getServicePort(it.service, it.port) },
  )

  /**
   * Класс для хранения информации о сервисе и порте.
   *
   * @property service Имя сервиса.
   * @property port Порт, на котором будет доступен сервис.
   */
  data class AppInfo(
    val service: String,
    val port: Int,
  )
}
