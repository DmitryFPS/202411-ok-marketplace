import kotlinx.datetime.LocalDateTime
import ru.otus.orlov.social_network_be.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ResponseV1SerializationTest {
  private val response: IResponse = StoryCreateResponse(
    story = StoryResponseObject(
      content = "text",
      expiresAt = LocalDateTime.DEFAULT_EXPIRES.toString(),
      mediaUrl = "url",
      visibility = StoryVisibility.PUBLIC,
      id = "123",
      ownerId = "321",
      lock = "lock",
      createdAt = LocalDateTime.DEFAULT.toString(),
      viewsCount = 1L,
      permissions = setOf(StoryPermissions.READ)
    )
  )

  @Test
  fun serialize() {
    val json = apiV1Mapper.encodeToString(response)

    println(json)

    // Проверяем остальные поля
    assertContains(json, Regex("\"id\":\\s*\"123\""))
    assertContains(json, Regex("\"content\":\\s*\"text\""))
    assertContains(json, Regex("\"expiresAt\":\\s*\"${LocalDateTime.DEFAULT_EXPIRES}\""))
    assertContains(json, Regex("\"mediaUrl\":\\s*\"url\""))
    assertContains(json, Regex("\"visibility\":\\s*\"public\""))
    assertContains(json, Regex("\"ownerId\":\\s*\"321\""))
    assertContains(json, Regex("\"lock\":\\s*\"lock\""))
    assertContains(json, Regex("\"createdAt\":\\s*\"${LocalDateTime.DEFAULT}\""))
    assertContains(json, Regex("\"viewsCount\":\\s*1"))
    assertContains(json, Regex("\"permissions\":\\s*\\[\"read\"]"))
  }

  @Test
  fun deserialize() {
    val json = apiV1Mapper.encodeToString(response)
    val obj = apiV1Mapper.decodeFromString<IResponse>(json) as StoryCreateResponse

    assertEquals(response, obj)
  }
}
