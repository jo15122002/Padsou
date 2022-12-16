package com.example.padsou.ui.add_plan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.shared.TopPageTitle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AddPlanView(){
    val db = Firebase.firestore
    Column(modifier =
    Modifier
        .background(Color(0xFF5f67ea))
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        TopPageTitle("Ajouter", "Un bon plan pour en faire profiter les autres")
        Column() {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddPlanViewPreview() {
    AddPlanView()
}