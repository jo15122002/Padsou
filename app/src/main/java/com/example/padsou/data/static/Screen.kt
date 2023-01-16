package com.example.padsou.data.static

import com.example.padsou.R

sealed class Screen(val route: String, val icon: Int) {
    object OnBoarding : Screen("onBoarding", R.drawable.ic_home)
    object Home : Screen("home", R.drawable.ic_home)
    object SignUp : Screen("signUp", R.drawable.ic_home)
    object SignIn : Screen("signIn", R.drawable.ic_home)
    object AddPlan : Screen("addPlan", R.drawable.ic_add)
    object Profile : Screen("profile", R.drawable.ic_profile)
}
