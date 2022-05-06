package dev.akash.githubissues.data.remote

import dev.akash.githubissues.data.model.issuelist.RemoteGitHubIssueResponse
import retrofit2.Response
import retrofit2.http.GET

interface GitHubIssueApiService {
    @GET("repos/square/okhttp/issues")
    suspend fun getIssueList() : Response<RemoteGitHubIssueResponse>
}