package com.example.padsou.ui.add_plan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddPlanPage(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),

        ) {
        Text("add plan page")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultAddPlanPagePreview() {
    AddPlanPage()
}