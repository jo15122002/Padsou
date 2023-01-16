package com.example.padsou.ui.shared

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.database.Database
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.SignIn.SignInView
import com.example.padsou.ui.SignUp.SignUpView
import com.example.padsou.ui.add_plan.AddPlanView
import com.example.padsou.ui.home.HomeView
import com.example.padsou.ui.home.HomeViewModel
import com.example.padsou.ui.onboarding.onBoardingPage
import com.example.padsou.ui.profile.ProfileView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun PadsouNavHost(
    homeViewModel: HomeViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
){
    Log.d("ViewModel", "init nav host")

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.OnBoarding.route) {
            onBoardingPage(onNavigate = { navController.navigate(Screen.SignUp.route) })
                Database.loadHomePageData()
        }

        composable(Screen.SignUp.route){
            SignUpView(onNavigateToSignIn = {navController.navigate(Screen.SignIn.route)}, onNavigateToPlans = {navController.navigate(Screen.Home.route)})}

        composable(Screen.SignIn.route){
            SignInView(onNavigateToHome = {navController.navigate(Screen.Home.route)}, onNavigateToSignUp = {navController.navigate(Screen.SignUp.route)})
        }

        composable(Screen.Home.route) {
            Log.d("ViewModel", "init composable")
            HomeView(navController, homeViewModel)
        }
        composable(Screen.AddPlan.route) { AddPlanView(navController) }
        composable(Screen.Profile.route) { ProfileView(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPadsouNavHostPreview() {
    PadsouNavHost(homeViewModel = HomeViewModel())
}