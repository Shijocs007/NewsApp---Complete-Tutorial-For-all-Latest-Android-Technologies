package com.example.newsappmvi.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsappmvi.presentation.common.PagerIndicator

@Composable
fun OnboardingFooter(
    modifier: Modifier = Modifier,
    pageCount : Int = 3,
    selectedPage : Int = 0,
    button1 : String ,
    button2 : String,
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PagerIndicator(
            modifier = Modifier.width(52.dp),
            pageSize = pageCount,
            selectedPage = selectedPage
        )

        OnboardingButtons(
            button1 = button1,
            button2 = button2,
            onBackClick = {
                onBackClick()
            },
            onNextClick = {
                onNextClick()
            }
        )
    }
}


@Preview
@Composable
private fun OnboardingFooterPrev() {
    OnboardingFooter(
        button1 = "Back",
        button2 = "Next"
    )
}