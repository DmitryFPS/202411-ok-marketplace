package fixture.client

import fixture.docker.DockerCompose
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Класс, реализующий HTTP-клиент для взаимодействия с REST API.
 * Использует [DockerCompose] для получения базового URL и [HttpClient] для выполнения HTTP-запросов.
 *
 * @property dockerCompose Объект [DockerCompose], предоставляющий базовый URL для подключения к сервису.
 * @constructor Создает экземпляр [RestClient] с указанным [DockerCompose].
 *
 * @see Client Интерфейс, который реализует данный класс.
 */
class RestClient(dockerCompose: DockerCompose) : Client {

  /**
   * Билдер URL, инициализируемый лениво
   * Ленивая инициализация гарантирует, что URL будет построен только при первом использовании.
   */
  private val urlBuilder by lazy { dockerCompose.inputUrl }

  /**
   * HTTP-клиент, используемый для выполнения запросов.
   * Инициализируется с использованием движка OkHttp.
   */
  private val client = HttpClient(OkHttp)

  /**
   * Отправляет HTTP-запрос и получает ответ от сервера.
   *
   * @param version Версия API, которая будет использоваться в пути запроса.
   * @param path Путь к конечной точке API.
   * @param request Тело запроса в виде строки.
   * @return Ответ от сервера в виде строки.
   *
   * @throws Exception Если произошла ошибка при выполнении запроса.
   */
  override suspend fun sendAndReceive(version: String, path: String, request: String): String {
    val url = urlBuilder.apply {
      path("$version/$path")
    }.build()

    val resp = client.post {
      url(url)
      headers {
        append(HttpHeaders.ContentType, ContentType.Application.Json)
      }
      accept(ContentType.Application.Json)
      setBody(request)
    }.call

    return resp.body()
  }
}
