package com.example.padsou.ui.onboarding.slider

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.PlanProfile
import com.example.padsou.ui.shared.SliderCheckmark




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun onBoardingSliderContent(){


    Column(
        verticalArrangement = Arrangement.spacedBy(11.dp),
        modifier = Modifier.width(250.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            PlanProfile(onPlanClick = {})
            PlanProfile(onPlanClick = {})
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            PlanProfile(onPlanClick = {})
            PlanProfile(onPlanClick = {})
        }
    }



}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultOnBoardingSliderPreview() {
    onBoardingSliderContent()
}