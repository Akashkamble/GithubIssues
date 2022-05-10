package dev.akash.githubissues.ui.commentlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import dev.akash.githubissues.ui.commentlist.components.CommentItem

/**
 * This is the screen where we will display the all the comments
 * related to the issue.
 */
@Destination
@Composable
fun CommentListScreen(
    issueNumber: Int,
    viewModel: CommentListViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getCommentsForIssue(issueNumber)
    }
    CommentListContent(viewState = viewState.value)
}

@Composable
fun CommentListContent(viewState: CommentListUiStatedata, modifier: Modifier = Modifier) {
    Surface(color = Color.White) {
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            when {
                viewState.isLoadingComments -> {
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
                viewState.commentList.isNotEmpty() -> {
                    LazyColumn(
                        modifier = modifier.fillMaxSize(),
                        contentPadding = PaddingValues(all = 16.dp)
                    ) {
                        items(viewState.commentList) { comment ->
                            CommentItem(commentInfo = comment, modifier = modifier)
                        }
                    }
                }
            }
        }
    }
}

