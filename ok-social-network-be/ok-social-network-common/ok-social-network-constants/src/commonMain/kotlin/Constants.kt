import kotlinx.datetime.*

private val DEFAULT_DATE = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
val LocalDateTime.Companion.DEFAULT
  get() = DEFAULT_DATE

private val DEFAULT_EXPIRES_AT = Clock.System.now()
  .plus(1, DateTimeUnit.DAY, TimeZone.currentSystemDefault())
  .toLocalDateTime(TimeZone.currentSystemDefault())
val LocalDateTime.Companion.DEFAULT_EXPIRES
  get() = DEFAULT_EXPIRES_AT
