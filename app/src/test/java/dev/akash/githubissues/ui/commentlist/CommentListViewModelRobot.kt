package dev.akash.githubissues.ui.commentlist

import com.google.common.truth.Truth
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.CommentInfo
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.repo.FakeIssueRepository
import dev.akash.githubissues.ui.issuelist.IssueListUiState
import dev.akash.githubissues.ui.issuelist.IssueListViewModel
import org.hamcrest.CoreMatchers.any

class CommentListViewModelRobot {

    private val fakePaletteRepository = FakeIssueRepository()
    private lateinit var viewModel: CommentListViewModel

    fun buildViewModel() = apply {
        viewModel = CommentListViewModel(
            fakePaletteRepository.mock
        )
    }

    suspend fun getCommentListForIssueNumber(issueNumber : Int) = apply {
        viewModel.getCommentsForIssue(issueNumber = issueNumber)
    }

    fun mockCommentListResult(result: Result<List<CommentInfo>>) = apply {
        fakePaletteRepository.mockCommentListResult(result)
    }

    fun assertViewState(expectedViewState: CommentListUiStatedata) = apply {
        val actualViewState = viewModel.viewState.value
        Truth.assertThat(actualViewState).isEqualTo(expectedViewState)
    }
}