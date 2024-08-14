package com.example.newsappmvi.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsappmvi.ui.theme.Blue
import com.example.newsappmvi.ui.theme.BlueGray

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pageSize : Int,
    selectedPage : Int,
    selectedPageColor : Color = Blue,
    unselectedPageColor : Color = BlueGray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier.size(14.dp)
                    .clip(CircleShape)
                    .background(color = if(page == selectedPage) selectedPageColor else unselectedPageColor)
            )
        }
    }
}


@Preview
@Composable
private fun PagerIndicatorPreview() {
    PagerIndicator(
        modifier = Modifier.width(52.dp),
        pageSize = 3,
        selectedPage = 0
    )
}