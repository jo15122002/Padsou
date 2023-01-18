package com.example.padsou.ui.profile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.static.Screen
import com.example.padsou.data.store.UserStore
import com.example.padsou.ui.shared.Layout
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfileView(navController: NavHostController){

    val context = LocalContext.current
    val dataStore = UserStore(context)
    val scope = rememberCoroutineScope()

    Layout(
        navController =navController,
        content = {
            ProfilePage(onDisconnect = {
                scope.launch {
                    dataStore.saveOption(false)
                    Manager.disconnectUser()
                    navController.navigate(Screen.SignUp.route)
                }
            })
        }
    )

}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun DefaultProfileViewPreview() {
    ProfileView(navController = rememberNavController())
}