package com.example.newsappmvi.navigation

import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object SplashScreen : Route()

    @Serializable
    data object OnBoardingScreen : Route()

    @Serializable
    data object HomeScreen : Route()

    @Serializable
    data object LoginScreen : Route()
}