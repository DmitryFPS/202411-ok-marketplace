package models

import kotlin.jvm.JvmInline

@JvmInline
value class StoryAdLock(private val lock: String) {
  fun asString() = lock

  companion object {
    val NONE = StoryAdLock("")
  }
}
