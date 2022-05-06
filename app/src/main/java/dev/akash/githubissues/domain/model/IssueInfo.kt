package dev.akash.githubissues.domain.model

import dev.akash.githubissues.data.model.issuelist.RemoteGitHubIssueResponseItem

data class IssueInfo(
    val id: Long,
    val title: String,
    val description: String,
    val user: User,
    val commentsUrl: String
)

fun IssueInfo.getShortDescription(): String {
    return if (this.description.length <= 200) {
        this.description
    } else {
        "${this.description.substring(IntRange(0, 199))}..."
    }
}

data class User(
    val userName: String,
    val avatarUrl: String
)

fun RemoteGitHubIssueResponseItem.toIssueInfo(): IssueInfo {
    return IssueInfo(
        id = this.id,
        title = this.title,
        description = this.body ?: "Description not available",
        user = User(
            userName = this.user.login,
            avatarUrl = this.user.avatarUrl
        ),
        commentsUrl = this.commentsUrl
    )
}
