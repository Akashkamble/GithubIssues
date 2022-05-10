package dev.akash.githubissues.ui.issuelist

import dev.akash.githubissues.CoroutinesTestRule
import dev.akash.githubissues.data.DataFetchingException
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.domain.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class IssueListViewModelTest {
    private val testRobot = IssueListViewModelRobot()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()


    @Test
    fun checkIfInitialStateIsLoading() {
        val initialState = IssueListUiState()

        testRobot
            .buildViewModel()
            .assertViewState(expectedViewState = initialState)
    }
    @Test
    fun fetchIssueListSuccessfully() = runTest {
        val issue = IssueInfo(
            id = 1L,
            title = "Test Title",
            description = "Test Description",
            user = User(
                userName = "Akashkamble",
                avatarUrl = "Some Random Image url"
            ),
            comments = 0,
            issueNumber = 5354
        )

        val initialState = IssueListUiState()
        val expectedList = listOf(issue)
        val issueListResult = Result.Success(expectedList)

        testRobot
            .mockIssueListResult(issueListResult)
            .buildViewModel()
            .getIssueList()
            .assertViewState(
                expectedViewState = initialState.copy(
                    isLoading = false,
                    issueInfoList = expectedList
                )
            )
    }


    @Test
    fun fetchIssueListWithError() = runTest {
        val errorMessage = "Something went wrong"
        val throwable = DataFetchingException(errorMessage)
        val initialState = IssueListUiState()
        val issueListResult = Result.Error(throwable)

        testRobot
            .mockIssueListResult(issueListResult)
            .buildViewModel()
            .getIssueList()
            .assertViewState(
                expectedViewState = initialState.copy(
                    isLoading = false,
                    errorMessage = errorMessage
                )
            )
    }
}