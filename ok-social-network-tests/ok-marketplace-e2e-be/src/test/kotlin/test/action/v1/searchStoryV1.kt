package test.action.v1

import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.matchers.should
import ru.otus.orlov.social_network_be.api.v1.models.StoryFindFilter
import ru.otus.orlov.social_network_be.api.v1.models.StoryFindRequest
import ru.otus.orlov.social_network_be.api.v1.models.StoryFindResponse
import ru.otus.orlov.social_network_be.api.v1.models.StoryResponseObject

suspend fun Client.searchStory(search: StoryFindFilter): List<StoryResponseObject> = searchStory(search) {
  it should haveSuccessResult
  it.stories ?: listOf()
}

suspend fun <T> Client.searchStory(search: StoryFindFilter, block: (StoryFindResponse) -> T): T =
  withClue("searchStoryV1: $search") {
    val response = sendAndReceive(
      "story/search",
      StoryFindRequest(
        debug = debug,
        storyFilter = search,
      )
    ) as StoryFindResponse

    response.asClue(block)
  }
