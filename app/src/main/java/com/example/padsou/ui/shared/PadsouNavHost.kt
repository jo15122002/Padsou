package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Route
import com.example.padsou.ui.home.HomePage
import com.example.padsou.ui.onboarding.onBoardingPage
import com.example.padsou.ui.theme.MainPurple


@Composable
fun PadsouNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.Home.name
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.OnBoarding.name) {
            onBoardingPage(
                onNavigate = { navController.navigate(Route.Home.name) },
                /*...*/
            )
        }
        composable(Route.Home.name) { HomePage() }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPadsouNavHostPreview() {
    PadsouNavHost()
}