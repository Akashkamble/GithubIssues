package dev.akash.githubissues.ui.commentlist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.akash.githubissues.domain.model.CommentInfo

@Composable
fun CommentItem(
    commentInfo: CommentInfo,
    modifier: Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = commentInfo.user.userName,
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = commentInfo.comment,
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                )
            )
        }
        Divider(
            color = Color.LightGray, modifier = modifier.fillMaxWidth()
        )
    }
}