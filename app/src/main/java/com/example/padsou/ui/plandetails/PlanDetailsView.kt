package com.example.padsou.ui.plandetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.shared.Layout

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanDetailsView(navController: NavHostController, planId: String?, viewModel: PlanDetailsViewModel = PlanDetailsViewModel()){

    planId?.let {
        viewModel.setPlanId(it)
    } ?: run {
        navController.navigate(Screen.Home.route)
    }

    Layout(
        navController =navController,
        content = {
            PlanDetailsPage(viewModel)
        }
    )

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPlanDetailsPreview() {
    PlanDetailsView(navController = rememberNavController(), "")
}