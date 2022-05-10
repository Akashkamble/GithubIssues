package dev.akash.githubissues.domain.model

import dev.akash.githubissues.data.model.commentlist.RemoteCommentResponseItem
import java.text.DateFormat

data class CommentInfo(
    val comment : String,
    val user : User
)

fun RemoteCommentResponseItem.toCommentInfo() : CommentInfo {
    return CommentInfo(
        comment = this.body,
        user = User(
            userName = this.user.login,
            avatarUrl = this.user.avatarUrl
        )
    )
}