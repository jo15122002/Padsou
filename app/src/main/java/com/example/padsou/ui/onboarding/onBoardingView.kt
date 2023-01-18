package com.example.padsou.ui.onboarding

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.viewpager.widget.ViewPager
import com.example.padsou.ui.theme.MainCorail
import com.example.padsou.ui.theme.MainPurple
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun onBoardingPage(onNavigate : ()->Unit){

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MainPurple)
            .padding(top = 98.dp, bottom = 47.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Column() {
            Text("PAS DE SOUS ?", color = Color.White, style = MaterialTheme.typography.h1)
            Text("Y'A PADSOU.", color = MainCorail, style = MaterialTheme.typography.h1)
        }
        onBoardingSlider()

        /*Button(
            onClick = onNavigate,
            modifier = Modifier
                .background(MainCorail, shape = RoundedCornerShape(18.dp))
                .padding(horizontal = 67.dp, vertical = 18.dp),
        ) {
            Text("C'EST PARTI !", color = Color.White, style = MaterialTheme.typography.h3)
        }*/

        Box(modifier = Modifier
            .clickable { onNavigate() }
            .background(MainCorail, shape = RoundedCornerShape(18.dp))
            .padding(horizontal = 67.dp, vertical = 18.dp),
        ) {
            Text("C'EST PARTI !", color = Color.White, style = MaterialTheme.typography.h3)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultOnBoardingPreview() {
    onBoardingPage(onNavigate = {})
}