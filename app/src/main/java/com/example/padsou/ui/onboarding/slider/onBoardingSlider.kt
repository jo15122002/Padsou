package com.example.padsou.ui.onboarding

import com.example.padsou.R

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.onboarding.slider.onBoardingSliderContent
import com.example.padsou.ui.shared.SliderCheckmark


@OptIn(ExperimentalPagerApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun onBoardingSlider(){
    val state = rememberPagerState()
    Column (
        modifier = Modifier
            .padding(horizontal = 65.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        DotsIndactor(nb = 3, selected = state.currentPage)
        HorizontalPager(count = 3, state = state) { page ->
            when(page){
                0-> Image(painter = painterResource(R.drawable.screenshot_1), contentDescription = "", modifier = Modifier
                    .height(300.dp)
                    .aspectRatio(1f)
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
                1-> Image(painter = painterResource(R.drawable.screenshot_2), contentDescription = "", modifier = Modifier
                    .height(300.dp)
                    .aspectRatio(1f)
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
                2-> Image(painter = painterResource(R.drawable.screenshot_3), contentDescription = "", modifier = Modifier
                    .height(300.dp)
                    .aspectRatio(1f)
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ), alignment = Alignment.TopCenter , contentScale = ContentScale.Crop)
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

@Composable
fun DotsIndactor(nb:Int, selected:Int){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {
        items(nb){ index ->
            if(index == selected){
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .width(25.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = Color.White)
                )
            } else {
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .width(25.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .alpha(0.5f)
                        .background(color = Color.White)
                )
            }

            if (index != nb - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            }
        }
    }
}