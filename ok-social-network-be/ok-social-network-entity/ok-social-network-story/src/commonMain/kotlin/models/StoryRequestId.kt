package models

import kotlin.jvm.JvmInline

@JvmInline
value class StoryRequestId(private val id: String) {
  fun asString() = id

  companion object {
    val NONE = StoryRequestId("")
  }
}
