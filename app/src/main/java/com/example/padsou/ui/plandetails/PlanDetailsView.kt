package com.example.padsou.ui.plandetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.profile.ProfilePage
import com.example.padsou.ui.shared.Layout

@Composable
fun PlanDetailsView(navController: NavHostController){

    Layout(
        navController =navController,
        content = {
            PlanDetailsPage()
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPlanDetailsPreview() {
    PlanDetailsView(navController = rememberNavController())
}