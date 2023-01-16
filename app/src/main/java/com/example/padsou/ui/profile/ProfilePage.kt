package com.example.padsou.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.MainPurple
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.padsou.ui.shared.CategoryProfile
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.SeeMore


@Composable
fun ProfilePage(){

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainPurple)
            .padding(top = 58.dp)

    ) {
        item{
            Column(Modifier.padding(horizontal = 33.dp, vertical = 20.dp)){
                Text("TON COMPTE", color = Color.White, style = MaterialTheme.typography.h1)
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                    .background(BackgroundWhite)
                    .padding(28.dp, 30.dp),
            ) {
                Spacer(modifier = Modifier.height(39.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}