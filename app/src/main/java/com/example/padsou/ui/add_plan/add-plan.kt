package com.example.padsou.ui.add_plan

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AddPlan(){
    val db = Firebase.firestore
    Column(modifier = Modifier.background(Color(0xFF5f67ea))) {
        Text(text = "Ajouter un bon plan")
    }
}


@Preview(showBackground = true)
@Composable
fun AddPlanPreview() {

}