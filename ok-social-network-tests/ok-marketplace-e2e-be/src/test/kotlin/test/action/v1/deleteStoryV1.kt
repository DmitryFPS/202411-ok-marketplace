package test.action.v1

import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import ru.otus.orlov.social_network_be.api.v1.models.StoryDeleteObject
import ru.otus.orlov.social_network_be.api.v1.models.StoryDeleteRequest
import ru.otus.orlov.social_network_be.api.v1.models.StoryDeleteResponse
import ru.otus.orlov.social_network_be.api.v1.models.StoryResponseObject

suspend fun Client.deleteStory(story: StoryResponseObject) {
  val id = story.id
  val lock = story.lock
  withClue("deleteStoryV1: $id, lock: $lock") {
    id should beValidId
    lock should beValidLock

    val response = sendAndReceive(
      "story/delete",
      StoryDeleteRequest(
        debug = debug,
        story = StoryDeleteObject(id = id, lock = lock)
      )
    ) as StoryDeleteResponse

    response.asClue {
      response should haveSuccessResult
      response.story shouldBe story
    }
  }
}
