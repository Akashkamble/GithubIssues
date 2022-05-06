package dev.akash.githubissues.ui.issuelist

import dev.akash.githubissues.domain.model.IssueInfo

data class IssueListUiState(
    val isLoading: Boolean = true,
    val issueInfoList: List<IssueInfo> = emptyList(),
    val errorMessage: String = "",
)