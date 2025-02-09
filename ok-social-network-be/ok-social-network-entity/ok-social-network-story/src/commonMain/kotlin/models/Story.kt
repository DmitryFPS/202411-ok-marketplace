package models

import DEFAULT
import DEFAULT_EXPIRES
import kotlinx.datetime.LocalDateTime
import ru.otus.orlov.social_network_be.api.v1.models.StoryPermissions
import ru.otus.orlov.social_network_be.api.v1.models.StoryVisibility


data class Story(
  var id: StoryId = StoryId.NONE,
  var content: String = "",
  var expiresAt: LocalDateTime = LocalDateTime.DEFAULT_EXPIRES,
  var createdAt: LocalDateTime = LocalDateTime.DEFAULT,
  var mediaUrl: String = "",
  var viewsCount: Long = 0,

  var ownerId: String = "",
  val permissions: Set<StoryPermissions> = mutableSetOf(),
  var visibility: StoryVisibility = StoryVisibility.PUBLIC,
  var lock: StoryAdLock = StoryAdLock.NONE
) {
  fun isEmpty() = this == NONE

  companion object {
    private val NONE = Story()
  }
}
