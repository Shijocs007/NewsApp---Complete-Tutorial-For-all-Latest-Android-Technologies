package com.example.newsappmvi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappmvi.presentation.MainViewModel
import com.example.newsappmvi.presentation.home.HomeScreen
import com.example.newsappmvi.presentation.onboarding.OnBoardingEvent
import com.example.newsappmvi.presentation.onboarding.OnBoardingScreen
import com.example.newsappmvi.presentation.onboarding.OnboardingViewmodel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun NavGraph(startDestination : Route) {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = startDestination) {
        composable<Route.OnBoardingScreen> {
            val onboardingViewmodel : OnboardingViewmodel = hiltViewModel()
            OnBoardingScreen(
                state = onboardingViewmodel.onboardingState.collectAsState().value,
                onEvent = { event ->
                    onboardingViewmodel.onEvent(event)
                }
            )
        }
        composable<Route.HomeScreen> {
            HomeScreen()
        }
    }
}