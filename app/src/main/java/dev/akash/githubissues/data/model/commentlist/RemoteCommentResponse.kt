package dev.akash.githubissues.data.model.commentlist


import com.google.gson.annotations.SerializedName
import dev.akash.githubissues.data.model.common.Reactions
import dev.akash.githubissues.data.model.common.User

class RemoteCommentResponse : ArrayList<RemoteCommentResponseItem>()
data class RemoteCommentResponseItem(
    @SerializedName("author_association")
    val authorAssociation: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("issue_url")
    val issueUrl: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any,
    @SerializedName("reactions")
    val reactions: Reactions,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: User
)

