package com.example.padsou.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.onboarding.slider.onBoardingSliderContent
import com.example.padsou.ui.shared.SliderCheckmark


@Composable
fun onBoardingSlider(){

    Column (
        modifier = Modifier
            .padding(horizontal = 65.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            SliderCheckmark(true)
            SliderCheckmark()
            SliderCheckmark()
        }
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(25.dp))
                .padding(15.dp)
        ) {
            onBoardingSliderContent()
        }
        Text("Accède aux 500 bons plans qu’on te propose chaque mois", color = Color.White, textAlign = TextAlign.Center)
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultOnBoardingSliderPreview() {
    onBoardingSlider()
}