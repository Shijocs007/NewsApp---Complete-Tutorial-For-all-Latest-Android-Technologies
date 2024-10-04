package com.example.newsappmvi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
            NewsAppMVITheme{
                Box(modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()) {
                    val state = viewModel.startDestination.collectAsStateWithLifecycle()
                    NavGraph(startDestination = state.value)
                }
            }
            }
        }
}

