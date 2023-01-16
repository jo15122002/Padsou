package com.example.padsou.ui.add_plan

import android.view.Gravity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.AddPlanStepMarker
import com.example.padsou.ui.shared.TextInputWithTitle
import com.example.padsou.ui.shared.TopPageTitle
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import coil.compose.AsyncImage

@Composable
fun AddPlanPhotoPage(navController : NavHostController){
    Column(modifier =
    Modifier
        .background(MainPurple)
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        TopPageTitle("Ajouter", "Un bon plan pour en faire profiter les autres")
        Column (modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(BackgroundWhite)
            .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.height(27.dp))
            Row() {
                AddPlanStepMarker(filled = true)
                Spacer(modifier = Modifier.width(12.dp))
                AddPlanStepMarker(filled = false)
            }
            Spacer(modifier = Modifier.height(27.dp))
            Column(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .background(Color.Black)
                ,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .background(MainPurple, shape = RoundedCornerShape(18.dp))
                    .width(174.dp)
                    .aspectRatio(1f)
                    .clickable { },
                    contentAlignment = Alignment.Center,
                ){
                    AsyncImage(model = "https://cdn-icons-png.flaticon.com/512/17/17128.png", contentDescription = "Ajouter une photo", modifier = Modifier.width(65.dp))
                }
                Box(modifier = Modifier
                    .clickable { }
                    .background(MainPurple, shape = RoundedCornerShape(18.dp))
                    .padding(horizontal = 133.dp, vertical = 18.dp)
                    ) {
                    Text("Ajouter ce bon plan", color = Color.White, style = MaterialTheme.typography.h3)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultAddPlanPhotoPagePreview() {
    AddPlanPhotoPage(rememberNavController())
}