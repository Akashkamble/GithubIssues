package dev.akash.githubissues.ui.issuelist

import dev.akash.githubissues.domain.model.IssueInfo

/**
 * This is the UI state for GitHubIssueListScreen.
 * @param isLoading indicates whether we got the data from API or not.
 * @param issueInfoList gives us list of issues mentioned under OkHttp library.
 * @param errorMessage indicates some error has occured while getting the data from data source.
 */
data class IssueListUiState(
    val isLoading: Boolean = true,
    val issueInfoList: List<IssueInfo> = emptyList(),
    val errorMessage: String = "",
)