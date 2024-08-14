package com.example.newsappmvi.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    state: OnBoardingState,              // Pass the current state
    onEvent: (OnBoardingEvent) -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = { 3 })


        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }
                .distinctUntilChanged()  // Only react to changes in the page index
                .collect { pageIndex ->
                    onEvent(OnBoardingEvent.OnboardingSwiped(selectedPage = pageIndex))
                }
        }

        HorizontalPager(state = pagerState) {
            OnBoardingPage(page = (state as OnBoardingState.OnboardingCurrentPageState).page)
        }
        Spacer(modifier = Modifier.weight(1f))
        OnboardingFooter(
            pageCount = 3,
            selectedPage = pagerState.currentPage,
            button1 = (state as OnBoardingState.OnboardingCurrentPageState).button[0],
            button2 = (state as OnBoardingState.OnboardingCurrentPageState).button[1],
            onBackClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage -1)
                }
            },
            onNextClick = {
                if(pagerState.currentPage == 2) {
                    onEvent(OnBoardingEvent.SaveOnboardingStatus)
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }

            }

        )
    }
}

