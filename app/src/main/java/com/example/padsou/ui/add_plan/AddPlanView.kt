package com.example.padsou.ui.add_plan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.Layout


@Composable
fun AddPlanView(navController: NavHostController){

    Layout(
        content = {
            AddPlanPage()
        },
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultProfilePagePreview() {
    AddPlanView(navController = rememberNavController())
}