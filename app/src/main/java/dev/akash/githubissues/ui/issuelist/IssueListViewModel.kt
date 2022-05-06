package dev.akash.githubissues.ui.issuelist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.akash.githubissues.data.IssueRepository
import dev.akash.githubissues.data.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class IssueListViewModel @Inject constructor(val repo: IssueRepository) : ViewModel() {

    private val _viewState: MutableStateFlow<IssueListUiState> =
        MutableStateFlow(IssueListUiState())

    val viewState: StateFlow<IssueListUiState> = _viewState

    suspend fun getIssueList() {
        when (val result = repo.getGithubIssue()) {
            is Result.Error -> {
                _viewState.value = viewState.value.copy(
                    isLoading = false,
                    errorMessage = result.error.localizedMessage ?: "Something went wrong"
                )
            }
            is Result.Success -> {
                _viewState.value = viewState.value.copy(
                    isLoading = false,
                    issueInfoList = result.data
                )
            }
        }
    }
}