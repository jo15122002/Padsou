package com.example.padsou.ui.add_plan

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

@Composable
fun AddPlanDescPage(navController: NavHostController, navigateToAddPlanPhoto : () -> Unit){
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
                AddPlanStepMarker(filled = false)
                Spacer(modifier = Modifier.width(12.dp))
                AddPlanStepMarker(filled = false)
            }
            Spacer(modifier = Modifier.height(32.dp))
            TextInputWithTitle(placeholder = "Abonnement de 1 an Basic-Fit", title = "Titre")
            Spacer(modifier = Modifier.height(32.dp))
            TextInputWithTitle(placeholder = "Ne soit pas trop bavard, on s'en fout va à l'essentiel :D", height = 119.dp, title = "Description")
            Spacer(modifier = Modifier.height(32.dp))
            TextInputWithTitle(placeholder = "www.lienVersTonBonPlan.com", title = "Lien")
            Spacer(modifier = Modifier.height(32.dp))
            Box(modifier = Modifier
                .clickable { navigateToAddPlanPhoto() }
                .background(MainPurple, shape = RoundedCornerShape(18.dp))
                .padding(horizontal = 133.dp, vertical = 18.dp)
            ) {
                Text("SUIVANT", color = Color.White, style = MaterialTheme.typography.h3)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultAddPlanPagePreview() {
    AddPlanDescPage(navController = rememberNavController(), {})
}