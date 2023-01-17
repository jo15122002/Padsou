package com.example.padsou.ui.plansbycategories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.shared.Layout


@Composable
fun PlansByCategoriesView(navController: NavHostController, categoryId: String?, viewModel: PlansByCategoriesViewModel = PlansByCategoriesViewModel()){

    categoryId?.let {
        viewModel.setCategoryId(it)
    } ?: run {
        navController.navigate(Screen.Home.route)
    }

    Layout(
        navController = navController,
        content = {
            Box(
                Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            ){
                PlansByCategoriesPage(navigateBack = {
                    navController.navigate(Screen.Home.route)
                }, viewModel)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPlansByCategoryViewViewPreview() {
    PlansByCategoriesView(navController = rememberNavController(), categoryId = "previewId")
}