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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.ui.destinations.IssueDetailsScreenDestination
import dev.akash.githubissues.ui.issuelist.components.IssueList

/**
 * This is a first screen of an app.
 * Where you can see the list of issues filed under square's okhttp library.
 */
@Destination(
    start = true
)
@Composable
fun GitHubIssueListScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    viewModel: IssueListViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getIssueList()
    }

    GitHubIssueListContent(viewState = viewState.value, modifier) { issue ->
        navigator.navigate(IssueDetailsScreenDestination(issueInfo = issue))
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