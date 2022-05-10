package dev.akash.githubissues.data.remote

import dev.akash.githubissues.data.model.commentlist.RemoteCommentResponse
import dev.akash.githubissues.data.model.issuelist.RemoteGitHubIssueResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubIssueApiService {
    @GET("repos/square/okhttp/issues")
    suspend fun getIssueList() : Response<RemoteGitHubIssueResponse>

    @GET("repos/square/okhttp/issues/{issueNumber}/comments")
    suspend fun getCommentsFor( @Path("issueNumber") issueNumber : Int) : Response<RemoteCommentResponse>
}