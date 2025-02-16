package models

data class StoryId(private val id: String) {
  fun asString() = id

  companion object {
    val NONE = StoryId("")
  }
}
