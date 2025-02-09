package test

import createStory
import fixture.client.Client
import io.kotest.assertions.asClue
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldExist
import io.kotest.matchers.collections.shouldExistInOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import ru.otus.orlov.social_network_be.api.v1.models.StoryFindFilter
import ru.otus.orlov.social_network_be.api.v1.models.StoryUpdateObject
import test.action.v1.*

fun FunSpec.testApiV1(client: Client, prefix: String = "") {
  context("${prefix}v1") {
    test("Create Story ok") {
      client.createStory()
    }

    test("Read Story ok") {
      val created = client.createStory()
      client.readStory(created.id).asClue {
        it shouldBe created
      }
    }

    test("Update Story ok") {
      val created = client.createStory()
      val updateStory = StoryUpdateObject(
        id = created.id,
        lock = created.lock,
        content = "text",
        expiresAt = created.expiresAt,
        mediaUrl = created.mediaUrl,
        visibility = created.visibility,
      )
      client.updateStory(updateStory)
    }

    test("Delete Story ok") {
      val created = client.createStory()
      client.deleteStory(created)
    }

    test("Search Story ok") {
      val created1 = client.createStory(someCreateStory.copy(content = "text"))
      val created2 = client.createStory(someCreateStory.copy(content = "text"))

      withClue("Search") {
        val results = client.searchStory(search = StoryFindFilter(findStorages = "1"))
        results shouldHaveSize 2
        results shouldExist { it.content == created1.content }
        results shouldExist { it.content == created2.content }
      }

      withClue("Search") {
        client.searchStory(search = StoryFindFilter(findStorages = "1"))
          .shouldExistInOrder({ it.content == created1.content })
      }
    }
  }
}
