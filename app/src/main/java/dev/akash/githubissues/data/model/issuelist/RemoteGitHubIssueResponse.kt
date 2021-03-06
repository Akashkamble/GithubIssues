package dev.akash.githubissues.data.model.issuelist

import com.google.gson.annotations.SerializedName
import dev.akash.githubissues.data.model.common.Reactions
import dev.akash.githubissues.data.model.common.User


class RemoteGitHubIssueResponse : ArrayList<RemoteGitHubIssueResponseItem>()
data class RemoteGitHubIssueResponseItem(
    @SerializedName("active_lock_reason")
    val activeLockReason: Any,
    @SerializedName("assignee")
    val assignee: Any,
    @SerializedName("assignees")
    val assignees: List<Any>,
    @SerializedName("author_association")
    val authorAssociation: String,
    @SerializedName("body")
    val body: String?,
    @SerializedName("closed_at")
    val closedAt: Any,
    @SerializedName("comments")
    val comments: Int,
    @SerializedName("comments_url")
    val commentsUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("draft")
    val draft: Boolean,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("labels")
    val labels: List<Label>,
    @SerializedName("labels_url")
    val labelsUrl: String,
    @SerializedName("locked")
    val locked: Boolean,
    @SerializedName("milestone")
    val milestone: Milestone,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any,
    @SerializedName("pull_request")
    val pullRequest: PullRequest,
    @SerializedName("reactions")
    val reactions: Reactions,
    @SerializedName("repository_url")
    val repositoryUrl: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("timeline_url")
    val timelineUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: User
)

data class Creator(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("followers_url")
    val followersUrl: String,
    @SerializedName("following_url")
    val followingUrl: String,
    @SerializedName("gists_url")
    val gistsUrl: String,
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("organizations_url")
    val organizationsUrl: String,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    @SerializedName("starred_url")
    val starredUrl: String,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

data class Label(
    @SerializedName("color")
    val color: String,
    @SerializedName("default")
    val default: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("url")
    val url: String
)

data class Milestone(
    @SerializedName("closed_at")
    val closedAt: Any,
    @SerializedName("closed_issues")
    val closedIssues: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("creator")
    val creator: Creator,
    @SerializedName("description")
    val description: String,
    @SerializedName("due_on")
    val dueOn: Any,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("labels_url")
    val labelsUrl: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("open_issues")
    val openIssues: Int,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)

data class PullRequest(
    @SerializedName("diff_url")
    val diffUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("merged_at")
    val mergedAt: Any,
    @SerializedName("patch_url")
    val patchUrl: String,
    @SerializedName("url")
    val url: String
)

