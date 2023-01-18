package com.example.padsou.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(viewModel: HomeViewModel = HomeViewModel(), onCategoryClick: (String)->Unit, onPlanClick: (String)->Unit, onVoirTout:()->Unit){

    val showSearchView:State<Boolean> = viewModel.showSearchView.collectAsState()
    val isLoadedCategory: State<Boolean> = viewModel.isLoadedCategory.collectAsState()
    val isLoadedPlan: State<Boolean> = viewModel.isLoadedPlan.collectAsState()
    val isLoaded = isLoadedCategory.value && isLoadedPlan.value

    Log.d("ViewModel", "init Home page")

    LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MainPurple)
                .padding(top = 58.dp)
    ) {
        item{
            Column(Modifier.padding(horizontal = 33.dp)){
                Text("COUCOU TOI,", color = Color.White, style = MaterialTheme.typography.h1)
                Text("T'es en manque de thunes ?", color = Color.White, style = MaterialTheme.typography.body1)
                Box(modifier = Modifier.padding(top = 45.dp, bottom = 34.dp)){
                    SearchBar(
                        placeholder = {
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
                        },
                        onSearch = {
                            viewModel.search(it)
                        },
                        setLoaded = {
                            viewModel.setLoadedPlan(it)
                        }
                    )
                }
            }
        }
        if(isLoaded){
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillParentMaxHeight()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(BackgroundWhite)
                        .padding(28.dp, 30.dp),
                ) {
                    if(showSearchView.value){
                        HomeSearchView(viewModel, onPlanClick)
                    }else {
                        DefaultHomeView(viewModel, onCategoryClick, onPlanClick, onVoirTout)
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
