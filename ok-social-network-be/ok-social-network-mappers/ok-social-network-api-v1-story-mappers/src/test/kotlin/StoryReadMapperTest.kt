import kotlinx.datetime.LocalDateTime
import models.*
import org.junit.Test
import ru.otus.orlov.social_network_be.api.v1.models.*
import stubs.StoryStubs
import kotlin.test.assertEquals

class StoryReadMapperTest {
  @Test
  fun fromTransport() {
    val req = StoryReadRequest(
      debug = StoryDebug(
        mode = StoryRequestDebugMode.STUB,
        stub = StoryRequestDebugStubs.SUCCESS,
      ),
      story = StoryReadObject(
        id = "1"
      ),
    )

    val context = StoryContext()
    context.fromTransport(req)

    assertEquals(StoryStubs.SUCCESS, context.stubCase)
    assertEquals(StoryWorkMode.STUB, context.workMode)
    assertEquals(StoryCommand.READ, context.command)
    assertEquals(StoryId("1"), context.storyRequest.id)
    assertEquals("", context.storyRequest.content)
    assertEquals(LocalDateTime.DEFAULT_EXPIRES, context.storyRequest.expiresAt)
    assertEquals(LocalDateTime.DEFAULT, context.storyRequest.createdAt)
    assertEquals("", context.storyRequest.mediaUrl)
    assertEquals(0, context.storyRequest.viewsCount)
    assertEquals("", context.storyRequest.ownerId)
  }

  @Test
  fun toTransport() {
    val context = StoryContext(
      requestId = StoryRequestId("1234"),
      command = StoryCommand.READ,
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
          group = "read",
          field = "name",
          message = "wrong name",
        )
      ),
      state = StoryState.RUNNING,
    )

    val req = context.toTransportStory() as StoryReadResponse
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
