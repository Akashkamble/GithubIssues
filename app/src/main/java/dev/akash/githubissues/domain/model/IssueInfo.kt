package dev.akash.githubissues.domain.model

import android.os.Parcelable
import dev.akash.githubissues.data.model.issuelist.RemoteGitHubIssueResponseItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IssueInfo(
    val id: Long,
    val title: String,
    val description: String,
    val user: User,
    val comments: Int,
    val issueNumber : Int
) : Parcelable

fun IssueInfo.getShortDescription(): String {
    return if (this.description.length <= 200) {
        this.description
    } else {
        "${this.description.substring(IntRange(0, 199))}..."
    }
}

fun RemoteGitHubIssueResponseItem.toIssueInfo(): IssueInfo {
    return IssueInfo(
        id = this.id,
        title = this.title,
        description = this.body ?: "Description not available",
        user = User(
            userName = this.user.login,
            avatarUrl = this.user.avatarUrl
        ),
        comments = this.comments,
        issueNumber = this.number
    )
}
