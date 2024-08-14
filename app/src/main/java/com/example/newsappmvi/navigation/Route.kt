package com.example.newsappmvi.navigation

import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object OnBoardingScreen : Route()

    @Serializable
    data object HomeScreen : Route()
}