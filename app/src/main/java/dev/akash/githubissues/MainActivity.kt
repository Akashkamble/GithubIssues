package dev.akash.githubissues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import dev.akash.githubissues.ui.NavGraphs
import dev.akash.githubissues.ui.theme.GithubIssuesTheme

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubIssuesTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}