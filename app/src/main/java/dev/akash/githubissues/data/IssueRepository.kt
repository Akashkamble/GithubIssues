package dev.akash.githubissues.data

import dev.akash.githubissues.data.model.issuelist.RemoteGitHubIssueResponse
import dev.akash.githubissues.domain.model.IssueInfo

interface IssueRepository {
    suspend fun getGithubIssue() : Result<List<IssueInfo>>
}