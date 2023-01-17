package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.shared.NavigationBar.BottomBar
import com.example.padsou.ui.theme.IconBackground
import com.example.padsou.ui.theme.IconColor
import com.example.padsou.ui.theme.MainPurple

@Composable
fun Layout(content : @Composable ()->Unit, navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        ) {

        Scaffold(
            content = {
                Box(Modifier
                    .padding(bottom = 70.dp)) {
                    content()
                }
            },
            bottomBar = { BottomBar(navController = navController) }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultProfilePagePreview() {
    Layout(
        navController = rememberNavController(),
        content = {}
    )
}