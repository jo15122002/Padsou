package com.example.padsou.ui.home

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.Permissions.PermissionsChecker
import com.example.padsou.ui.shared.Layout
import com.google.accompanist.permissions.*


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeView(navController: NavHostController){

    val permissionState = rememberMultiplePermissionsState(permissions = listOf(Manifest.permission.POST_NOTIFICATIONS))

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !permissionState.allPermissionsGranted){
        PermissionsChecker(permissionsState = permissionState, description = "Test")
    }

    Layout(
        navController = navController,
        content = {
            Box(Modifier.fillMaxHeight()){
                HomePage(
                    onCategoryClick = { id ->
                        navController.navigate(Screen.PlansByCategory.route+"/"+id)
                    },
                    onPlanClick = { id ->
                        navController.navigate(Screen.PlanDetails.route+"/"+id)
                    },
                    onVoirTout = {
                        navController.navigate(Screen.AllPlans.route)
                    }
                )
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultHomeViewPreview() {
    HomeView(navController = rememberNavController())
}