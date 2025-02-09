package exceptions

import models.StoryCommand

class UnknownStoryCommand(command: StoryCommand) :
  Throwable("Wrong command $command at mapping toTransport stage")
