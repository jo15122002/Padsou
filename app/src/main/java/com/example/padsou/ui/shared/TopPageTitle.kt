package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopPageTitle(title:String, subTitle:String){
    Column(modifier = Modifier.background(Color(0xFF5f67ea))) {
        Text(text = title)
        Text(text = subTitle)
    }
}


@Preview(showBackground = true)
@Composable
fun TopPageTitlePreview() {
    TopPageTitle("Un titre", "Un sous-titre")
}