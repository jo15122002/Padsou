package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.core.text.buildSpannedString
import com.example.padsou.R
import com.example.padsou.data.database.Database
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.CategoryProfile
import com.example.padsou.ui.shared.PlanProfile
import com.example.padsou.ui.shared.TextInput
import com.example.padsou.ui.shared.shimmerBackground
import com.example.padsou.ui.theme.*


@Composable
fun HomePage(viewModel: HomeViewModel = HomeViewModel()){

    val categories: State<List<Category>> = viewModel.categories.collectAsState()
    val isLoaded: State<Boolean> = viewModel.isLoaded.collectAsState()

    Log.d("ViewModel", "init Home page")

    var data = listOf(
        listOf(
            Plan.defaultPlan(),
            Plan.defaultPlan(),
            Plan.defaultPlan(),
            Plan.defaultPlan(),
        ),
        listOf(
            Plan.defaultPlan(),
            Plan.defaultPlan(),
            Plan.defaultPlan(),
        )
    )


    LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MainPurple)
                .padding(top = 58.dp)

    ) {
        item{
            Column(Modifier.padding(horizontal = 33.dp)){
                Text("COUCOU TOI,", color = Color.White, style = MaterialTheme.typography.h1)
                Text("T'es en manque de thunes ?", color = Color.White, style = MaterialTheme.typography.body1)
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
        }
        if(isLoaded.value){
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(BackgroundWhite)
                        .padding(28.dp, 30.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        categories.value.map { c ->
                            CategoryProfile(c)
                        }
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
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        data.forEach { list ->
                            Column(
                                Modifier
                                    .weight(1f)
                            ) {
                                list.forEach { plan ->
                                    PlanProfile(plan, true)
                                }
                            }
                        }
                    }
                }
            }
        }else{
            item{
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(BackgroundWhite)
                        .padding(28.dp, 30.dp)
                ) {
                    Box(
                        Modifier
                            .height(15.dp)
                            .fillMaxWidth()
                            .shimmerBackground(RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    }
}
