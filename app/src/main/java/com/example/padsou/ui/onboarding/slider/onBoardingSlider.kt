package com.example.padsou.ui.onboarding

import com.example.padsou.R

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


@OptIn(ExperimentalPagerApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun onBoardingSlider(){

    Column (
        modifier = Modifier
            .padding(horizontal = 65.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        HorizontalPager(count = 3) { page ->
            when(page){
                0-> Image(painter = painterResource(R.drawable.screenshot_1), contentDescription = "", modifier = Modifier.height(300.dp).aspectRatio(1f).padding(10.dp).clip(
                    RoundedCornerShape(20.dp)), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
                1-> Image(painter = painterResource(R.drawable.screenshot_2), contentDescription = "", modifier = Modifier.height(300.dp).aspectRatio(1f).padding(10.dp).clip(
                    RoundedCornerShape(20.dp)), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
                2-> Image(painter = painterResource(R.drawable.screenshot_3), contentDescription = "", modifier = Modifier.height(300.dp).aspectRatio(1f).padding(10.dp).clip(
                    RoundedCornerShape(20.dp)), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
            }
        }
        /*Row(
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
        }*/
        Text("Accède aux 500 bons plans qu’on te propose chaque mois", color = Color.White, textAlign = TextAlign.Center)
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultOnBoardingSliderPreview() {
    onBoardingSlider()
}