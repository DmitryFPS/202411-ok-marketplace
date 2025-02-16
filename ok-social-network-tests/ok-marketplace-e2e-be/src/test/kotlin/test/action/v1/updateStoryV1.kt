package test.action.v1

import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import ru.otus.orlov.social_network_be.api.v1.models.StoryResponseObject
import ru.otus.orlov.social_network_be.api.v1.models.StoryUpdateObject
import ru.otus.orlov.social_network_be.api.v1.models.StoryUpdateRequest
import ru.otus.orlov.social_network_be.api.v1.models.StoryUpdateResponse

suspend fun Client.updateStory(story: StoryUpdateObject): StoryResponseObject =
  updateStory(story) {
    it should haveSuccessResult
    it.story shouldNotBe null
    it.story?.apply {
      content shouldBe story.content
      expiresAt shouldBe story.expiresAt
      if (mediaUrl != null) mediaUrl shouldBe story.mediaUrl
      if (visibility != null) visibility shouldBe story.visibility
      if (id != null) id shouldBe story.id
      if (lock != null) lock shouldBe story.lock
    }
    it.story!!
  }

suspend fun <T> Client.updateStory(story: StoryUpdateObject, block: (StoryUpdateResponse) -> T): T {
  val id = story.id
  val lock = story.lock
  return withClue("updatedV1: $id, lock: $lock, set: $story") {
    id should beValidId
    lock should beValidLock

    val response = sendAndReceive(
      "story/update", StoryUpdateRequest(
        debug = debug,
        story = story.copy(id = id, lock = lock)
      )
    ) as StoryUpdateResponse

    response.asClue(block)
  }
}
