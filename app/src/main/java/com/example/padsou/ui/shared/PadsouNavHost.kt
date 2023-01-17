package com.example.padsou.ui.shared

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.padsou.data.database.Database
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.add_plan.AddPlanDescPage
import com.example.padsou.ui.SignIn.SignInView
import com.example.padsou.ui.SignUp.SignUpView
import com.example.padsou.ui.add_plan.AddPlanPhotoPage
import com.example.padsou.ui.add_plan.AddPlanView
import com.example.padsou.ui.home.HomeView
import com.example.padsou.ui.home.HomeViewModel
import com.example.padsou.ui.onboarding.onBoardingPage
import com.example.padsou.ui.plansbycategories.PlansByCategoriesView
import com.example.padsou.ui.profile.ProfileView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun PadsouNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.OnBoarding.route
){
    Log.d("ViewModel", "init nav host")

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.OnBoarding.route) {
            onBoardingPage(onNavigate = { navController.navigate(Screen.SignUp.route) })
        }

        composable(Screen.SignUp.route){
            SignUpView(onNavigateToSignIn = {navController.navigate(Screen.SignIn.route)}, onNavigateToPlans = {navController.navigate(Screen.Home.route)})}

        composable(Screen.SignIn.route){
            SignInView(onNavigateToHome = {navController.navigate(Screen.Home.route)}, onNavigateToSignUp = {navController.navigate(Screen.SignUp.route)})
        }

        composable(Screen.AddPlan.route) { AddPlanDescPage(navController, { navController.navigate(Screen.AddPlanPhoto.route) }) }
        composable(Screen.AddPlanPhoto.route) { AddPlanPhotoPage(navController) }
        composable(Screen.Home.route) {
            Log.d("ViewModel", "init composable")
            HomeView(navController)
        }
        composable(Screen.Profile.route) { ProfileView(navController) }
        composable(
            Screen.PlansByCategory.route +"/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            PlansByCategoriesView(navController, categoryId)
        }

    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun DefaultPadsouNavHostPreview() {
    PadsouNavHost()
}