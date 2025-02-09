import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import ru.otus.orlov.social_network_be.api.v1.models.StoryCreateObject
import ru.otus.orlov.social_network_be.api.v1.models.StoryCreateRequest
import ru.otus.orlov.social_network_be.api.v1.models.StoryCreateResponse
import ru.otus.orlov.social_network_be.api.v1.models.StoryResponseObject
import test.action.v1.debug
import test.action.v1.haveSuccessResult
import test.action.v1.sendAndReceive
import test.action.v1.someCreateStory

suspend fun Client.createStory(story: StoryCreateObject = someCreateStory): StoryResponseObject = createStory(story) {
  it should haveSuccessResult
  it.story shouldNotBe null
  it.story?.apply {
    content shouldBe story.content
    expiresAt shouldBe story.expiresAt
    mediaUrl shouldBe story.mediaUrl
    visibility shouldBe story.visibility
    createdAt shouldBe story.createdAt
    viewsCount shouldBe story.viewsCount
  }
  it.story!!
}

suspend fun <T> Client.createStory(story: StoryCreateObject = someCreateStory, block: (StoryCreateResponse) -> T): T =
  withClue("createStoryV1: $story") {
    val response = sendAndReceive(
      "story/create", StoryCreateRequest(
        debug = debug,
        story = story
      )
    ) as StoryCreateResponse

    response.asClue(block)
  }
