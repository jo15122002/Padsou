package com.example.padsou.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.models.User
import com.example.padsou.ui.home.HomePage
import com.example.padsou.ui.shared.Layout


@Composable
fun ProfileView(navController: NavHostController){

    Layout(
        navController =navController,
        content = {
            ProfilePage()
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultProfileViewPreview() {
    ProfileView(navController = rememberNavController())
}