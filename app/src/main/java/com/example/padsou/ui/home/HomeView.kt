package com.example.padsou.ui.home

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.Layout


@Composable
fun HomeView(navController: NavHostController){

    Layout(
        navController =navController,
        content = {
            HomePage()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultHomeViewPreview() {
    HomeView(navController = rememberNavController())
}