import kotlinx.datetime.LocalDateTime
import models.*
import org.junit.Test
import ru.otus.orlov.social_network_be.api.v1.models.*
import stubs.StoryStubs
import kotlin.test.assertEquals

class StoryUpdateMapperTest {
  @Test
  fun fromTransport() {
    val req = StoryUpdateRequest(
      debug = StoryDebug(
        mode = StoryRequestDebugMode.STUB,
        stub = StoryRequestDebugStubs.SUCCESS,
      ),
      story = StoryUpdateObject(
        id = "1",
        content = "text",
        expiresAt = LocalDateTime.DEFAULT_EXPIRES.toString(),
        mediaUrl = "mediaUrl",
        visibility = StoryVisibility.PUBLIC,
        lock = "lock",
      ),
    )

    val context = StoryContext()
    context.fromTransport(req)

    assertEquals(StoryStubs.SUCCESS, context.stubCase)
    assertEquals(StoryWorkMode.STUB, context.workMode)
    assertEquals(StoryId("1"), context.storyRequest.id)
    assertEquals("text", context.storyRequest.content)
    assertEquals(LocalDateTime.DEFAULT_EXPIRES.toString(), context.storyRequest.expiresAt.toString())
    assertEquals("mediaUrl", context.storyRequest.mediaUrl)
    assertEquals(0, context.storyRequest.viewsCount)
    assertEquals(StoryVisibility.PUBLIC, context.storyRequest.visibility)
    assertEquals(StoryAdLock("lock"), context.storyRequest.lock)
  }

  @Test
  fun toTransport() {
    val context = StoryContext(
      requestId = StoryRequestId("1234"),
      command = StoryCommand.UPDATE,
      storyResponse = Story(
        id = StoryId("1234"),
        content = "text",
        expiresAt = LocalDateTime.DEFAULT_EXPIRES,
        mediaUrl = "mediaUrl",
        viewsCount = 0,
        visibility = StoryVisibility.PUBLIC,
        lock = StoryAdLock.NONE
      ),
      errors = mutableListOf(
        StoryError(
          code = "err",
          group = "update",
          field = "name",
          message = "wrong name",
        )
      ),
      state = StoryState.RUNNING,
    )

    val req = context.toTransportStory() as StoryUpdateResponse
    assertEquals("1234", req.story?.id)
    assertEquals(StoryStubs.NONE, context.stubCase)
    assertEquals(StoryWorkMode.PROD, context.workMode)

    assertEquals("text", context.storyResponse.content)
    assertEquals(LocalDateTime.DEFAULT_EXPIRES, context.storyResponse.expiresAt)
    assertEquals("mediaUrl", context.storyResponse.mediaUrl)
    assertEquals(0, context.storyResponse.viewsCount)
    assertEquals(StoryVisibility.PUBLIC, context.storyResponse.visibility)
    assertEquals(StoryAdLock.NONE, context.storyResponse.lock)
  }
}
