package com.example.padsou.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.ListPlanProfile


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeSearchView(viewModel: HomeViewModel, onPlanClick: (id: String)->Unit){

    val searchPlans: State<List<Plan>> = viewModel.searchPlans.collectAsState()

    ListPlanProfile(searchPlans.value, onPlanClick)

}