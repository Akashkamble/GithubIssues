package dev.akash.githubissues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.akash.githubissues.ui.issuelist.GitHubIssueListScreen
import dev.akash.githubissues.ui.theme.GithubIssuesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubIssuesTheme {
                GitHubIssueListScreen()
            }
        }
    }
}