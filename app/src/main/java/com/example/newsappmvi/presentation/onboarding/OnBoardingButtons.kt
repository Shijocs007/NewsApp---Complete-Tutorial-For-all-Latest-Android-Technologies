package com.example.newsappmvi.presentation.onboarding

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsappmvi.ui.theme.Blue
import com.example.newsappmvi.ui.theme.WhiteGray

@Composable
fun OnboardingButtons(
    modifier: Modifier = Modifier,
    button1 : String,
    button2 : String,
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if(button1.isNotEmpty()) {
            TextButton(onClick = {
                onBackClick()
            }) {
                Text(
                    text = button1,
                    color = WhiteGray,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                )
            }
        }

        if(button2.isNotEmpty()) {

            Button(
                onClick = {
                    onNextClick()
                },
                shape = RoundedCornerShape(size = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = button2,
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                )
            }
        }
    }
}


@Preview
@Composable
private fun OnboardingButtonsPreview() {
    OnboardingButtons(
        button1 = "Back",
        button2 = "Next"
    )
}