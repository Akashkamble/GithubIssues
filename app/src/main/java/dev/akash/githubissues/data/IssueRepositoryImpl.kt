package dev.akash.githubissues.data

import dev.akash.githubissues.data.remote.GitHubIssueApiService
import dev.akash.githubissues.domain.model.IssueInfo
import dev.akash.githubissues.domain.model.toIssueInfo
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IssueRepositoryImpl @Inject constructor(
    val apiService: GitHubIssueApiService
) : IssueRepository {
    override suspend fun getGithubIssue(): Result<List<IssueInfo>> {
        val result = withContext(Dispatchers.IO) {
            try {
                val response = apiService.getIssueList()
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(data = response.body()!!.map { remoteIssue ->
                        remoteIssue.toIssueInfo()
                    })
                } else {
                    return@withContext Result.Error(DataFetchingException("No data found"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                if (e.localizedMessage!!.contains("Unable to resolve host")) {
                    return@withContext Result.Error(DataFetchingException("No internet connection"))
                } else {
                    return@withContext Result.Error(DataFetchingException("Something went wrong"))
                }
            }
        }
        return result
    }
}

class DataFetchingException(message: String) : Exception(message)