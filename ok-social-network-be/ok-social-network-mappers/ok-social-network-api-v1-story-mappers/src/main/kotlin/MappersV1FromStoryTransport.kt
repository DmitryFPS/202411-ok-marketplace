import exceptions.UnknownRequestClass
import kotlinx.datetime.LocalDateTime
import models.*
import ru.otus.orlov.social_network_be.api.v1.models.*
import stubs.StoryStubs

fun StoryContext.fromTransport(request: IRequest) = when (request) {
  is StoryCreateRequest -> fromTransport(request)
  is StoryReadRequest -> fromTransport(request)
  is StoryUpdateRequest -> fromTransport(request)
  is StoryDeleteRequest -> fromTransport(request)
  is StoryFindRequest -> fromTransport(request)
  else -> throw UnknownRequestClass(request.javaClass)
}

fun parseDate(dateString: String): LocalDateTime = LocalDateTime.parse(dateString)

private fun StoryDebug?.transportToWorkMode(): StoryWorkMode = when (this?.mode) {
  StoryRequestDebugMode.PROD -> StoryWorkMode.PROD
  StoryRequestDebugMode.TEST -> StoryWorkMode.TEST
  StoryRequestDebugMode.STUB -> StoryWorkMode.STUB
  null -> StoryWorkMode.PROD
}

private fun StoryDebug?.transportToStubCase(): StoryStubs = when (this?.stub) {
  StoryRequestDebugStubs.SUCCESS -> StoryStubs.SUCCESS
  StoryRequestDebugStubs.NOT_FOUND -> StoryStubs.NOT_FOUND
  StoryRequestDebugStubs.BAD_ID -> StoryStubs.BAD_ID
  StoryRequestDebugStubs.BAD_CONTENT -> StoryStubs.BAD_CONTENT
  StoryRequestDebugStubs.CANNOT_DELETE -> StoryStubs.CANNOT_DELETE
  StoryRequestDebugStubs.BAD_SEARCH -> StoryStubs.BAD_SEARCH
  null -> StoryStubs.NONE
}

private fun String?.toStoryId() = this?.let { StoryId(it) } ?: StoryId.NONE
private fun String?.toStoryLock() = this?.let { StoryAdLock(it) } ?: StoryAdLock.NONE

private fun StoryCreateObject.toInternal(): Story = Story(
  content = this.content,
  expiresAt = parseDate(this.expiresAt),
  createdAt = parseDate(this.createdAt),
  mediaUrl = this.mediaUrl ?: "",
  viewsCount = this.viewsCount ?: 0,
  visibility = this.visibility ?: StoryVisibility.PUBLIC,
)

private fun StoryUpdateObject.toInternal(): Story = Story(
  id = this.id.toStoryId(),
  content = this.content,
  expiresAt = parseDate(this.expiresAt),
  mediaUrl = this.mediaUrl ?: "",
  visibility = this.visibility ?: StoryVisibility.PUBLIC,
  lock = lock.toStoryLock(),
)

private fun StoryDeleteObject?.toInternal(): Story =
  this?.let { Story(id = id.toStoryId(), lock = lock.toStoryLock()) } ?: Story()

private fun StoryFindFilter?.toInternal(): StoryFilter = StoryFilter(
  findStorages = this?.findStorages ?: ""
)

private fun StoryReadObject?.toInternal(): Story = this?.let { Story(id = id.toStoryId()) } ?: Story()

fun StoryContext.fromTransport(request: StoryCreateRequest) {
  command = StoryCommand.CREATE
  storyRequest = request.story?.toInternal() ?: Story()
  workMode = request.debug.transportToWorkMode()
  stubCase = request.debug.transportToStubCase()
}

fun StoryContext.fromTransport(request: StoryReadRequest) {
  command = StoryCommand.READ
  storyRequest = request.story.toInternal()
  workMode = request.debug.transportToWorkMode()
  stubCase = request.debug.transportToStubCase()
}

fun StoryContext.fromTransport(request: StoryUpdateRequest) {
  command = StoryCommand.UPDATE
  storyRequest = request.story?.toInternal() ?: Story()
  workMode = request.debug.transportToWorkMode()
  stubCase = request.debug.transportToStubCase()
}

fun StoryContext.fromTransport(request: StoryDeleteRequest) {
  command = StoryCommand.DELETE
  storyRequest = request.story.toInternal()
  workMode = request.debug.transportToWorkMode()
  stubCase = request.debug.transportToStubCase()
}

fun StoryContext.fromTransport(request: StoryFindRequest) {
  command = StoryCommand.SEARCH
  storyFilterRequest = request.storyFilter.toInternal()
  workMode = request.debug.transportToWorkMode()
  stubCase = request.debug.transportToStubCase()
}
