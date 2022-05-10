package dev.akash.githubissues.repo

import dev.akash.githubissues.data.IssueRepository
import dev.akash.githubissues.data.Result
import dev.akash.githubissues.domain.model.CommentInfo
import dev.akash.githubissues.domain.model.IssueInfo
import io.mockk.coEvery
import io.mockk.mockk

class FakeIssueRepository {
        val mock: IssueRepository = mockk()

        fun mockIssueListResult(result: Result<List<IssueInfo>>) {
            coEvery {
                mock.getGithubIssue()
            } returns result
        }

        fun mockCommentListResult(result : Result<List<CommentInfo>>){
            coEvery {
                mock.getCommentsForIssue(any())
            } returns result
        }
}