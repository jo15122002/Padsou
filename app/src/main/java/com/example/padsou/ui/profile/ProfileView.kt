package com.example.padsou.ui.profile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.Layout


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfileView(navController: NavHostController){

    Layout(
        navController =navController,
        content = {
            ProfilePage()
        }
    )

}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun DefaultProfileViewPreview() {
    ProfileView(navController = rememberNavController())
}