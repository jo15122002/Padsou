package com.example.padsou.ui.add_plan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple

@Composable
fun AddPlanDescPage(navController: NavHostController, navigateToAddPlanPhoto : () -> Unit){
    Layout(content = { AddPlanContentDescPage(navController = navController, navigateToAddPlanPhoto = navigateToAddPlanPhoto) }, navController = navController)
}

@Composable
fun AddPlanContentDescPage(navController: NavHostController, navigateToAddPlanPhoto : () -> Unit){
    val titleInput = remember {
        InputState()
    }
    val descInput = remember {
        InputState()
    }
    val urlInput = remember {
        HyperLinkState()
    }
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
            .fillMaxHeight(1f)
            .padding(horizontal = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(27.dp))
            Row() {
                AddPlanStepMarker(filled = false)
                Spacer(modifier = Modifier.width(12.dp))
                AddPlanStepMarker(filled = false)
            }
            Spacer(modifier = Modifier.height(32.dp))
            InputFieldWithTitle(
                input = titleInput.text,
                error = titleInput.error,
                placeholder = "Abonnement de 1 an Basic-Fit",
                title = "Titre",
                onInputChanged = {
                    titleInput.text = it
                    titleInput.validate(null)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            InputFieldWithTitle(
                input = descInput.text,
                error = descInput.error,
                placeholder = "Ne soit pas trop bavard, on s'en fout va à l'essentiel :D",
                title = "Description",
                height = 119.dp,
                onInputChanged = {
                    descInput.text = it
                    descInput.validate(null)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            HyperlinkFieldWithTitle(
                input = urlInput.text,
                error = urlInput.error,
                placeholder = "www.lienVersTonBonPlan.com",
                title = "Lien",
                onInputChanged = {
                    urlInput.text = it
                    urlInput.validate(null)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
                onClick = {
                    navigateToAddPlanPhoto()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MainPurple,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(18.dp),
                enabled = titleInput.isValid() && descInput.isValid() && urlInput.isValid()
            ) {
                Text("SUIVANT", color = Color.White, style = MaterialTheme.typography.h3)
            }
            Spacer(modifier = Modifier.height(312.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultAddPlanPagePreview() {
    AddPlanDescPage(navController = rememberNavController(), {})
}