package com.example.padsou.ui.allplans

import com.example.padsou.ui.home.HomePage


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.plansbycategories.PlansByCategoriesViewModel
import com.example.padsou.ui.shared.Layout


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllPlansView(navController: NavHostController, viewModel: AllPlansViewModel = AllPlansViewModel()){

    Layout(
        navController = navController,
        content = {
            Box(Modifier.fillMaxHeight()){
                AllPlansPage(
                    navigateBack = {
                        navController.navigate(Screen.Home.route)
                    },
                    onPlanClick = { id ->
                        navController.navigate(Screen.PlanDetails.route+"/"+id)
                    },
                    viewModel
                )
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultHomeViewPreview() {
    AllPlansView(navController = rememberNavController())
}