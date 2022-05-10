package dev.akash.githubissues.ui.issuelist

import com.google.common.truth.Truth.assertThat
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.repo.FakeIssueRepository

class IssueListViewModelRobot {

    private val fakePaletteRepository = FakeIssueRepository()
    private lateinit var viewModel: IssueListViewModel

    fun buildViewModel() = apply {
        viewModel = IssueListViewModel(
            fakePaletteRepository.mock
        )
    }

    suspend fun getIssueList() = apply {
        viewModel.getIssueList()
    }

    fun mockIssueListResult(result: Result<List<IssueInfo>>) = apply {
        fakePaletteRepository.mockIssueListResult(result)
    }

    fun assertViewState(expectedViewState: IssueListUiState) = apply {
        val actualViewState = viewModel.viewState.value
        assertThat(actualViewState).isEqualTo(expectedViewState)
    }
}