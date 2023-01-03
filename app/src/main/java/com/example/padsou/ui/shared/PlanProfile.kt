package com.example.padsou.ui.shared

import com.example.padsou.ui.onboarding.onBoardingSlider

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.theme.MainCorail
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.TextBlack

@Composable
fun PlanProfile(
    plan: Plan = Plan.defaultPlan(),
    isBig: Boolean = false
){
    var height = 105.dp
    if(isBig) height = 150.dp

    Card(
        modifier = Modifier
            .padding(4.dp)
            .height(height)
            .then(
                if (isBig)
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                else
                    Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .width(100.dp)

            ),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(7.dp)) {
            Box(
                contentAlignment = Alignment.BottomCenter,
            ) {
                Box(
                    Modifier
                        .padding(bottom = 15.dp)
                ) {
                    AsyncImage(
                        model = plan.photoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .then(
                                if (isBig)
                                    Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .height(height * 3 / 5)
                                else
                                    Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .height(height / 2)
                            )
                            .fillMaxSize()
                    )
                }
                Card(
                    shape = CircleShape,
                    elevation = 0.dp,
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(3.dp),
                ) {
                    AsyncImage(
                        model = plan.logoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
            Column(Modifier.padding(horizontal = 10.dp)) {

                Text(text = plan.title, style = TextStyle(color = TextBlack, fontWeight = FontWeight.W700, fontSize = 11.sp))
                Text(text = plan.description, style = TextStyle(color = TextBlack, fontSize = 7.sp))
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPlanProfilePreview() {
    PlanProfile()
}