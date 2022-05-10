package dev.akash.githubissues.ui.issuedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.ui.destinations.CommentListScreenDestination

/**
 * This is the Details screen where we display issue details
 * like who created the issue i.e(username, avatar)
 * Title of the issue.
 * Description of the issue.
 * If there are comments in the issue we will see the button to see the comments.
 */
@Destination
@Composable
fun IssueDetailsScreen(
    issueInfo: IssueInfo,
    navigator: DestinationsNavigator
) {
    IssueDetailsContent(issueInfo = issueInfo) {
        navigator.navigate(CommentListScreenDestination(issueNumber = issueInfo.issueNumber))
    }
}

@Composable
fun IssueDetailsContent(
    modifier: Modifier = Modifier,
    issueInfo: IssueInfo,
    onSeeCommentClick: () -> Unit
) {
    Surface(color = Color.White) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Column(
                modifier = modifier.verticalScroll(state = rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(issueInfo.user.avatarUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = "User Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = issueInfo.user.userName,
                        style = TextStyle(
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Text(
                    text = issueInfo.title,
                    style = TextStyle(
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = issueInfo.description,
                    style = TextStyle(
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
                        fontSize = 14.sp,
                    )
                )
                /**
                 * Show button only when particular issue has comments.
                 * This prevents unnecessary api call for fetching comments.
                 */
                if (issueInfo.comments != 0) {
                    Button(onClick = onSeeCommentClick) {
                        Text(text = "See Comments")
                    }
                }
            }
        }
    }
}
