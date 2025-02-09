package test.action.v1

import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.and
import ru.otus.orlov.social_network_be.api.v1.models.IResponse
import ru.otus.orlov.social_network_be.api.v1.models.ResponseResult


fun haveResult(result: ResponseResult) = Matcher<IResponse> {
  MatcherResult(
    it.result == result,
    { "actual result ${it.result} but we expected $result" },
    { "result should not be $result" }
  )
}

val haveNoErrors = Matcher<IResponse> {
  MatcherResult(
    it.errors.isNullOrEmpty(),
    { "actual errors ${it.errors} but we expected no errors" },
    { "errors should not be empty" }
  )
}

val haveSuccessResult = haveResult(ResponseResult.SUCCESS) and haveNoErrors

val beValidId = Matcher<String?> {
  MatcherResult(
    it != null,
    { "id should not be null" },
    { "id should be null" },
  )
}

val beValidLock = Matcher<String?> {
  MatcherResult(
    true, // TODO заменить на it != null, когда заработают локи
    { "lock should not be null" },
    { "lock should be null" },
  )
}
