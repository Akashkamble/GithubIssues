package dev.akash.githubissues.ui.issuelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.ui.issuelist.components.IssueList

@Composable
fun GitHubIssueListScreen(
    modifier: Modifier = Modifier,
    viewModel: IssueListViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getIssueList()
    }

    GitHubIssueListContent(viewState = viewState.value, modifier) { issue ->

    }
}

@Composable
fun GitHubIssueListContent(
    viewState: IssueListUiState,
    modifier: Modifier,
    onIssueClick: (issue: IssueInfo) -> Unit
) {
    Surface(color = Color.White) {
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            when {
                viewState.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                            .testTag("loading issue list"),
                    )
                }
                viewState.errorMessage.isNotBlank() -> {
                    Text(
                        text = viewState.errorMessage,
                        modifier = modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .testTag("issue-list-loading-error")
                    )
                }
                viewState.issueInfoList.isNotEmpty() -> {
                    IssueList(
                        list = viewState.issueInfoList,
                        onIssueClick = onIssueClick
                    )
                }

            }
        }
    }
}