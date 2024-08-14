package com.example.newsappmvi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _showSplashScreen = MutableStateFlow(true)
    val showSplashScreen: StateFlow<Boolean> get() = _showSplashScreen

    init {
        viewModelScope.launch {
            delay(1000)
            _showSplashScreen.value = false
        }
    }
}