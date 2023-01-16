package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.Layout


@Composable
fun HomeView(navController: NavHostController){

    Log.d("ViewModel", "init home view")

    Layout(
        navController = navController,
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