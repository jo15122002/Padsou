package com.example.padsou.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.MainPurple

@Composable
fun ProfilePage(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),

        ) {
        Text("profile page")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultProfilePagePreview() {
    ProfilePage()
}