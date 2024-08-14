package com.example.newsappmvi.presentation.onboarding

import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsappmvi.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewmodel @Inject constructor()  : ViewModel() {


    private val _onboardingState = MutableStateFlow(
        OnBoardingState.OnboardingCurrentPageState(
            page = pages[0],
            button = getButtonTexts(0)
        )
    )

    val onboardingState : StateFlow<OnBoardingState> = _onboardingState


    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.OnboardingSwiped -> {
                _onboardingState.value = OnBoardingState.OnboardingCurrentPageState(
                    page = pages[event.selectedPage],
                    button = getButtonTexts(event.selectedPage)
                )
            }
        }
    }


    private fun getButtonTexts(page: Int): List<String> {
        return when (page) {
            0 -> listOf("", "Next")
            1 -> listOf("Back", "Next")
            2 -> listOf("Back", "Get Started")
            else -> listOf("", "")
        }

    }

    fun getPageCount() : Int {
        return pages.size
    }
}


sealed class OnBoardingEvent {

    data class OnboardingSwiped(
        val selectedPage : Int
    ): OnBoardingEvent()

}

    sealed class OnBoardingState {

        data class OnboardingCurrentPageState(
            val page: Page,
            val button: List<String>
        ) : OnBoardingState()

    }


data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

private val pages = listOf(
    Page(
        title = "Lorem Ipsum is simply dummy 11111",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry 11111.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is simply dummy 22222",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry 22222.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem Ipsum is simply dummy 33333",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry 33333.",
        image = R.drawable.onboarding3
    )
)

