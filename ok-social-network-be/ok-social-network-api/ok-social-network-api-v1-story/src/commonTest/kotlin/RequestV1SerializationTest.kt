import kotlinx.datetime.LocalDateTime
import ru.otus.orlov.social_network_be.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class RequestV1SerializationTest {
  private val request: IRequest = StoryCreateRequest(
    debug = StoryDebug(
      mode = StoryRequestDebugMode.STUB,
      stub = StoryRequestDebugStubs.SUCCESS
    ),
    story = StoryCreateObject(
      content = "text",
      expiresAt = LocalDateTime.DEFAULT_EXPIRES.toString(),
      mediaUrl = "url",
      visibility = StoryVisibility.PUBLIC,
      createdAt = LocalDateTime.DEFAULT.toString(),
      viewsCount = 1L
    )
  )

  @Test
  fun serialize() {
    val json = apiV1Mapper.encodeToString(IRequest.serializer(), request)

    println(json)

    assertContains(json, Regex("\"debug\":\\s*\\{"))
    assertContains(json, Regex("\"mode\":\\s*\"stub\""))
    assertContains(json, Regex("\"stub\":\\s*\"success\""))
    assertContains(json, Regex("\"story\":\\s*\\{"))
    assertContains(json, Regex("\"content\":\\s*\"text\""))
    assertContains(json, Regex("\"expiresAt\":\\s*\"${LocalDateTime.DEFAULT_EXPIRES}\""))
    assertContains(json, Regex("\"mediaUrl\":\\s*\"url\""))
    assertContains(json, Regex("\"visibility\":\\s*\"public\""))
    assertContains(json, Regex("\"createdAt\":\\s*\"${LocalDateTime.DEFAULT}\""))
    assertContains(json, Regex("\"viewsCount\":\\s*1"))
  }

  @Test
  fun deserialize() {
    val json = apiV1Mapper.encodeToString(request)
    val obj = apiV1Mapper.decodeFromString<IRequest>(json) as StoryCreateRequest

    assertEquals(request, obj)
  }

  @Test
  fun deserializeNaked() {
    val jsonString = """
            {"story": null}
        """.trimIndent()
    val obj = apiV1Mapper.decodeFromString<StoryCreateRequest>(jsonString)

    assertEquals(null, obj.story)
  }
}
