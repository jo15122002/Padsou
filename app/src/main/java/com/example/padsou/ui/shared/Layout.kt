package com.example.padsou.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.NavigationBar.BottomBar

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