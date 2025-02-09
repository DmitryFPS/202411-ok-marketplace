package test.action.v1

import ru.otus.orlov.social_network_be.api.v1.models.*

val debug = StoryDebug(mode = StoryRequestDebugMode.STUB, stub = StoryRequestDebugStubs.SUCCESS)

val someCreateStory = StoryCreateObject(
  content = "text",
  expiresAt = "2026-01-01T00:00:00.000Z",
  createdAt = "2025-01-01T00:00:00.000Z",
  mediaUrl = "/img/image.png",
  viewsCount = 0,
  visibility = StoryVisibility.PUBLIC
)
