package test.action.v1

import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.matchers.should
import io.kotest.matchers.shouldNotBe
import ru.otus.orlov.social_network_be.api.v1.models.StoryReadObject
import ru.otus.orlov.social_network_be.api.v1.models.StoryReadRequest
import ru.otus.orlov.social_network_be.api.v1.models.StoryReadResponse
import ru.otus.orlov.social_network_be.api.v1.models.StoryResponseObject


suspend fun Client.readStory(id: String?): StoryResponseObject = readStory(id) {
  it should haveSuccessResult
  it.story shouldNotBe null
  it.story!!
}

suspend fun <T> Client.readStory(id: String?, block: (StoryReadResponse) -> T): T =
  withClue("readStoryV1: $id") {
    id should beValidId

    val response = sendAndReceive(
      "story/read",
      StoryReadRequest(
        debug = debug,
        story = StoryReadObject(id = id)
      )
    ) as StoryReadResponse

    response.asClue(block)
  }
