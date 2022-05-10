package dev.akash.githubissues.ui.commentlist

import dev.akash.githubissues.domain.model.CommentInfo

data class CommentListUiStatedata (
    val isLoadingComments : Boolean = true,
    val commentList: List<CommentInfo> = emptyList(),
    val errorMessage : String = ""
)