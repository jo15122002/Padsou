package com.example.padsou.ui.shared.NavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.theme.IconBackground
import com.example.padsou.ui.theme.IconColor
import com.example.padsou.ui.theme.MainPurple


@Composable
fun RowScope.NavItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val contentColor =
        if (selected) MainPurple else IconColor

    Box(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 8.dp)
            .size(50.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(IconBackground)
            .clickable(onClick = {
                if(!selected){
                    navController.navigate(screen.route) {
                        // popUpTo(navController.graph.findStartDestination().id)
                        // launchSingleTop = true
                    }
                }
            }),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(screen.icon),
                contentDescription = "icon",
                tint = contentColor,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}