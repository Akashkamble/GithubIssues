package dev.akash.githubissues.ui.commentlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.akash.githubissues.data.IssueRepository
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.ui.destinations.IssueDetailsScreenDestination
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CommentListViewModel @Inject constructor(
    private val repository: IssueRepository
) : ViewModel() {

    private val _viewState: MutableStateFlow<CommentListUiStatedata> =
        MutableStateFlow(CommentListUiStatedata())

    val viewState: StateFlow<CommentListUiStatedata> = _viewState

    suspend fun getCommentsForIssue(issueNumber : Int){
        when(val result = repository.getCommentsForIssue(issueNumber = issueNumber)){
            is Result.Error -> {
                _viewState.value = viewState.value.copy(
                    isLoadingComments = false,
                    errorMessage = result.error.localizedMessage ?: "Something went wrong"
                )
            }
            is Result.Success -> {
                _viewState.value = viewState.value.copy(
                    isLoadingComments = false,
                    commentList = result.data
                )
            }
        }
    }
}