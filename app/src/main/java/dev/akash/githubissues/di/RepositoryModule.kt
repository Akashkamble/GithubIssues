package dev.akash.githubissues.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dev.akash.githubissues.data.IssueRepository
import dev.akash.githubissues.data.IssueRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGitHubIssueRepository(repository: IssueRepositoryImpl): IssueRepository
}