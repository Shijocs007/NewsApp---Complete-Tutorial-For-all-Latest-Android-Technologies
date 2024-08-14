package com.example.newsappmvi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsappmvi.navigation.NavGraph
import com.example.newsappmvi.navigation.Route
import com.example.newsappmvi.presentation.onboarding.OnBoardingEvent
import com.example.newsappmvi.presentation.onboarding.OnBoardingScreen
import com.example.newsappmvi.presentation.onboarding.OnboardingViewmodel
import com.example.newsappmvi.ui.theme.NewsAppMVITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            viewModel.showSplashScreen.value
        }
        enableEdgeToEdge()
        setContent {
            NavGraph(startDestination = Route.OnBoardingScreen)
            }
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppMVITheme {
      //  OnBoardingScreen()
    }
}