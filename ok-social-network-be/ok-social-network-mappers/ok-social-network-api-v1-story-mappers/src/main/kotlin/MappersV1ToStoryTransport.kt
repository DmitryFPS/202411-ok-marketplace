import exceptions.UnknownStoryCommand
import models.*
import ru.otus.orlov.social_network_be.api.v1.models.*


fun StoryContext.toTransportStory(): IResponse = when (val cmd = command) {
  StoryCommand.CREATE -> toTransportCreate()
  StoryCommand.READ -> toTransportRead()
  StoryCommand.UPDATE -> toTransportUpdate()
  StoryCommand.DELETE -> toTransportDelete()
  StoryCommand.SEARCH -> toTransportSearch()
  StoryCommand.NONE -> throw UnknownStoryCommand(cmd)
}

private fun StoryState.toResult(): ResponseResult? = when (this) {
  StoryState.RUNNING -> ResponseResult.SUCCESS
  StoryState.FAILING -> ResponseResult.ERROR
  StoryState.FINISHING -> ResponseResult.SUCCESS
  StoryState.NONE -> null
}

private fun List<StoryError>.toTransportErrors(): List<Error>? = this
  .map { it.toTransportStory() }
  .toList()
  .takeIf { it.isNotEmpty() }

private fun StoryError.toTransportStory() = Error(
  code = this.code.takeIf { it.isNotBlank() },
  group = this.group.takeIf { it.isNotBlank() },
  field = this.field.takeIf { it.isNotBlank() },
  message = this.message.takeIf { it.isNotBlank() },
)

private fun StoryPermission.toTransportStory() = when (this) {
  StoryPermission.READ -> StoryPermissions.READ
  StoryPermission.UPDATE -> StoryPermissions.UPDATE
  StoryPermission.MAKE_VISIBLE_PRIVATE -> StoryPermissions.MAKE_VISIBLE_PRIVATE
  StoryPermission.MAKE_VISIBLE_GROUP -> StoryPermissions.MAKE_VISIBLE_GROUP
  StoryPermission.MAKE_VISIBLE_PUBLIC -> StoryPermissions.MAKE_VISIBLE_PUBLIC
  StoryPermission.DELETE -> StoryPermissions.DELETE
}

private fun Set<StoryPermission>.toTransportStory(): Set<StoryPermissions>? = this
  .map { it.toTransportStory() }
  .toSet()
  .takeIf { it.isNotEmpty() }

fun List<Story>.toTransportStory(): List<StoryResponseObject>? = this
  .map { it.toTransportStory() }
  .toList()
  .takeIf { it.isNotEmpty() }

private fun Story.toTransportStory(): StoryResponseObject = StoryResponseObject(
  id = this.id.takeIf { it != StoryId.NONE }?.asString(),
  content = this.content,
  expiresAt = this.expiresAt.toString(),
  mediaUrl = this.mediaUrl,
  visibility = this.visibility,
  ownerId = this.ownerId,
  lock = this.lock.asString(),
  createdAt = this.createdAt.toString(),
  viewsCount = viewsCount,
  permissions = this.permissions
)

fun StoryContext.toTransportCreate() = StoryCreateResponse(
  result = this.state.toResult(),
  errors = this.errors.toTransportErrors(),
  story = this.storyResponse.toTransportStory()
)

fun StoryContext.toTransportRead() = StoryReadResponse(
  result = this.state.toResult(),
  errors = this.errors.toTransportErrors(),
  story = this.storyResponse.toTransportStory()
)

fun StoryContext.toTransportUpdate() = StoryUpdateResponse(
  result = this.state.toResult(),
  errors = this.errors.toTransportErrors(),
  story = this.storyResponse.toTransportStory()
)

fun StoryContext.toTransportDelete() = StoryDeleteResponse(
  result = this.state.toResult(),
  errors = this.errors.toTransportErrors(),
  story = this.storyResponse.toTransportStory()
)

fun StoryContext.toTransportSearch() = StoryFindResponse(
  result = this.state.toResult(),
  errors = this.errors.toTransportErrors(),
  stories = this.storiesResponse.toTransportStory()
)
