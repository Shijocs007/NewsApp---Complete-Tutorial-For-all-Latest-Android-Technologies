package com.example.newsappmvi.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsappmvi.R
import com.example.newsappmvi.ui.theme.Dimen.MediumPadding1
import com.example.newsappmvi.ui.theme.Dimen.MediumPadding2

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.60f),
            painter = painterResource(id = page.image),
            contentDescription =null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.black)
        )
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.black)
        )
    }
}


@Preview
@Composable
private fun OnBoardingPagePrev() {
    OnBoardingPage(
        page = Page(
            title = "fyfut svguydv dshvdsb suvdss s ugvsu",
            description = "vggutv gvytv sgvsu sugvs7 sugvs 7svs  s 7tsv susg ss7t s6sssts  gs s7s sg",
            image = R.drawable.onboarding1
        )
    )
}