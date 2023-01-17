package com.example.padsou.ui.plandetails

import android.content.ClipData.Item
import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Plan
import com.example.padsou.data.models.User
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple

@Composable
fun PlanDetailsPage(plan: Plan = Plan.defaultPlan(),){

    LazyColumn(
        Modifier
            .background(BackgroundWhite)
            .fillMaxHeight()
    ) {
        item {
            Box(
                Modifier.clip(RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
            ) {
                AsyncImage(
                    model = plan.photoUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .drawWithCache {
                            val gradient = Brush.horizontalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startX = size.width,
                                endX = size.width / 100
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        }
                        .fillMaxWidth()
                        .height(275.dp)
                )

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 120.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(plan.title, color = Color.White, style = MaterialTheme.typography.h2)
                }
            }
        }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 30.dp)

            ){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                ) {
                    Column(
                        Modifier.padding(20.dp)
                    ) {
                        Row() {
                            Column() {
                                Text("Proposé par", fontSize = 10.sp, color = Color(0xFFA6A6A6))
                                Text("Killian74", fontSize = 10.sp)
                            }
                        }
                        Text(plan.description)
                    }
                }
            }

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Testé par 32 galériens", style = MaterialTheme.typography.h4, textAlign = TextAlign.Center)
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                val uriHandler = LocalUriHandler.current
                Button(
                    onClick = {
                        uriHandler.openUri(plan.link)
                    },
                    shape = RoundedCornerShape(15.dp),
                    contentPadding = PaddingValues(horizontal = 70.dp, vertical = 18.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MainPurple,
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = "PROFITER DE L'OFFRE",
                        color = Color.White,
                        style = MaterialTheme.typography.h3)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlanDetailsPagePreview() {
    PlanDetailsPage()
}