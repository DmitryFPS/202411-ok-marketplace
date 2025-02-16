import kotlinx.datetime.LocalDateTime
import models.*
import stubs.StoryStubs

data class StoryContext(
  var command: StoryCommand = StoryCommand.NONE,
  var state: StoryState = StoryState.NONE,
  val errors: MutableList<StoryError> = mutableListOf(),

  var workMode: StoryWorkMode = StoryWorkMode.PROD,
  var stubCase: StoryStubs = StoryStubs.NONE,

  var requestId: StoryRequestId = StoryRequestId.NONE,
  var timeStart: LocalDateTime = LocalDateTime.DEFAULT,
  var storyRequest: Story = Story(),
  var storyFilterRequest: StoryFilter = StoryFilter(),

  var storyResponse: Story = Story(),
  var storiesResponse: MutableList<Story> = mutableListOf(),
)
