package dev.akash.githubissues.ui.commentlist

import dev.akash.githubissues.CoroutinesTestRule
import dev.akash.githubissues.data.DataFetchingException
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.CommentInfo
import dev.akash.githubissues.domain.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CommentListViewModelTest {

    private val testRobot = CommentListViewModelRobot()
    private val issueNumber = 5347

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun checkIfInitialUiStateIsLoading() {
        val initialState = CommentListUiStatedata()

        testRobot
            .buildViewModel()
            .assertViewState(expectedViewState = initialState)
    }

    @Test
    fun fetchCommentListSuccessfully() = runTest {
        val comment = CommentInfo(
            comment = "Test Comment",
            user = User(userName = "Akashkamble", avatarUrl = "Some random image url")
        )
        val expectedCommentList = listOf(comment)
        val initialState = CommentListUiStatedata()
        val expectedResult = Result.Success(data = expectedCommentList)

        testRobot
            .mockCommentListResult(expectedResult)
            .buildViewModel()
            .getCommentListForIssueNumber(issueNumber)
            .assertViewState(
                expectedViewState = initialState.copy(
                    isLoadingComments = false,
                    commentList = expectedCommentList
                )
            )
    }

    @Test
    fun fetchCommentListWithError() = runTest {
        val errorMessage = "Something went wrong"
        val throwable = DataFetchingException(errorMessage)
        val initialState = CommentListUiStatedata()
        val expectedResult = Result.Error(throwable)

        testRobot
            .mockCommentListResult(expectedResult)
            .buildViewModel()
            .getCommentListForIssueNumber(issueNumber)
            .assertViewState(
                expectedViewState = initialState.copy(
                    isLoadingComments = false,
                    errorMessage = errorMessage
                )
            )
    }
}