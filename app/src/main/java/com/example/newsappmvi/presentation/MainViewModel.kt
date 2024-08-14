package com.example.newsappmvi.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappmvi.navigation.Route
import com.example.newsappmvi.usecases.FetchOnBoardingStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val fetchOnBoardingStatus: FetchOnBoardingStatus
): ViewModel() {
    private val _showSplashScreen = MutableStateFlow(true)
    val showSplashScreen: StateFlow<Boolean> get() = _showSplashScreen

    private val _startDestination = MutableStateFlow<Route>(Route.OnBoardingScreen)
    val startDestination: StateFlow<Route> get() = _startDestination

    init {
        checkOnboardingstatus()
    }

    private fun checkOnboardingstatus() {
        fetchOnBoardingStatus().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Route.HomeScreen
            }else{
                _startDestination.value = Route.OnBoardingScreen
            }
            delay(300) //Without this delay, the onBoarding screen will show for a momentum.
            _showSplashScreen.value = false
        }.launchIn(viewModelScope)
    }
}