package com.example.padsou.ui.add_plan

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AddPlanView(navController: NavHostController){
    val db = Firebase.firestore
    //Layout(content = { AddPlanDescPage(rememberNavController()) }, navController = navController)
    //AddPlanDescPage()
    //AddPlanPhotoPage()
}


@Preview(showBackground = true)
@Composable
fun AddPlanViewPreview() {
    AddPlanView(navController = rememberNavController())
}