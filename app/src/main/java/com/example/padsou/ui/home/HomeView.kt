package com.example.padsou.ui.home

import android.util.Log
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
import com.example.padsou.ui.shared.Layout


@Composable
fun HomeView(navController: NavHostController){

    Log.d("ViewModel", "init home view")

    Layout(
        navController = navController,
        content = {
            Box(Modifier.fillMaxHeight()){
                HomePage(
                    onCategoryClick = { id ->
                        navController.navigate(Screen.PlansByCategory.route+"/"+id)
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultHomeViewPreview() {
    HomeView(navController = rememberNavController())
}