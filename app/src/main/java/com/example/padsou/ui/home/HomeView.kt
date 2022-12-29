package com.example.padsou.ui.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.onboarding.onBoardingSlider
import com.example.padsou.ui.shared.CategoryProfile
import com.example.padsou.ui.shared.PlanProfile
import com.example.padsou.ui.shared.TextInput
import com.example.padsou.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(){

    var text by remember {
        mutableStateOf("")
    }
    var data = ""

    Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(MainPurple)
                .padding(top = 58.dp),

    ) {
        Column(Modifier.padding(horizontal = 33.dp)){
            Text("COUCOU TOI,", color = Color.White, style = MaterialTheme.typography.h1)
            Text("T'es en manque de thunes ?,", color = Color.White, style = MaterialTheme.typography.body1)
            Box(modifier = Modifier.padding(top = 45.dp, bottom = 34.dp)){
                TextInput(placeholder = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_search_18dp),
                            contentDescription = "search icon",
                            tint = Placeholder
                        )
                        Text("Cherche un bon plan", color = Placeholder)
                    }
                })
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                .background(BackgroundWhite)
                .padding(28.dp, 30.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                CategoryProfile()
                CategoryProfile()
                CategoryProfile()
                CategoryProfile()
            }
            Spacer(modifier = Modifier.height(39.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text("Les plans du moments", style = MaterialTheme.typography.h4)
                Text("Voir tout", color = SeeMore, fontWeight = FontWeight.W700)
            }
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 22.dp)
            ) {
                items(3) {
                    PlanProfile(Plan.defaultPlan(), isBig = true)
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultHomePreview() {
    HomePage()
}