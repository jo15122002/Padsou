package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopPageTitle(title:String, subTitle:String){
    Column(
        modifier = Modifier
            .padding(58.dp)
            .background(Color(0xFF5f67ea))

    ) {
        Text(text = title, color = Color.White, style = MaterialTheme.typography.h1)
        Text(text = subTitle, color = Color.White, style = MaterialTheme.typography.h3)
    }
}


@Preview(showBackground = true)
@Composable
fun TopPageTitlePreview() {
    TopPageTitle("Un titre", "Un sous-titre")
}