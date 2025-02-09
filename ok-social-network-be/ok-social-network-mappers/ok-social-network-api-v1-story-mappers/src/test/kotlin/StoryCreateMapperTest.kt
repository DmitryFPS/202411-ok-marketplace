import kotlinx.datetime.LocalDateTime
import models.*
import org.junit.Test
import ru.otus.orlov.social_network_be.api.v1.models.*
import stubs.StoryStubs
import kotlin.test.assertEquals

class StoryCreateMapperTest {
  @Test
  fun fromTransport() {
    val req = StoryCreateRequest(
      debug = StoryDebug(
        mode = StoryRequestDebugMode.STUB,
        stub = StoryRequestDebugStubs.SUCCESS,
      ),
      story = StoryCreateObject(
        content = "text",
        expiresAt = LocalDateTime.DEFAULT_EXPIRES.toString(),
        createdAt = LocalDateTime.DEFAULT.toString(),
        mediaUrl = "mediaUrl",
        viewsCount = 0,
        visibility = StoryVisibility.PUBLIC,
      ),
    )

    val context = StoryContext()
    context.fromTransport(req)

    assertEquals(StoryStubs.SUCCESS, context.stubCase)
    assertEquals(StoryWorkMode.STUB, context.workMode)
    assertEquals("text", context.storyRequest.content)
    assertEquals(LocalDateTime.DEFAULT_EXPIRES.toString(), context.storyRequest.expiresAt.toString())
    assertEquals(LocalDateTime.DEFAULT.toString(), context.storyRequest.createdAt.toString())
    assertEquals("mediaUrl", context.storyRequest.mediaUrl)
    assertEquals(0, context.storyRequest.viewsCount)
    assertEquals(StoryVisibility.PUBLIC, context.storyRequest.visibility)
  }

  @Test
  fun toTransport() {
    val context = StoryContext(
      requestId = StoryRequestId("1234"),
      command = StoryCommand.CREATE,
      storyResponse = Story(
        id = StoryId("1234"),
        content = "text",
        expiresAt = LocalDateTime.DEFAULT_EXPIRES,
        createdAt = LocalDateTime.DEFAULT,
        mediaUrl = "mediaUrl",
        viewsCount = 0,
        visibility = StoryVisibility.PUBLIC,
        permissions = emptySet(),
        ownerId = "4321",
        lock = StoryAdLock.NONE
      ),
      errors = mutableListOf(
        StoryError(
          code = "err",
          group = "request",
          field = "name",
          message = "wrong name",
        )
      ),
      state = StoryState.RUNNING,
    )

    val req = context.toTransportStory() as StoryCreateResponse
    assertEquals("1234", req.story?.id)
    assertEquals(StoryStubs.NONE, context.stubCase)
    assertEquals(StoryWorkMode.PROD, context.workMode)

    assertEquals("text", context.storyResponse.content)
    assertEquals(LocalDateTime.DEFAULT_EXPIRES, context.storyResponse.expiresAt)
    assertEquals(LocalDateTime.DEFAULT, context.storyResponse.createdAt)
    assertEquals("mediaUrl", context.storyResponse.mediaUrl)
    assertEquals(0, context.storyResponse.viewsCount)
    assertEquals(StoryVisibility.PUBLIC, context.storyResponse.visibility)
    assertEquals(0, context.storyResponse.permissions.size)
    assertEquals("4321", context.storyResponse.ownerId)
    assertEquals(StoryAdLock.NONE, context.storyResponse.lock)
  }
}
