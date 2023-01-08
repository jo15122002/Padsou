package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.MainPurple

@Composable
fun AddPlanStepMarker(filled:Boolean = false){

    Box(
        Modifier
            .height(7.dp)
            .width(46.dp)
            .then(if(!filled)
                Modifier.background(color = Color(0xFFBABFCD).copy(alpha = 0.4f), shape = RoundedCornerShape(20.dp) )
            else
                Modifier.background(color = MainPurple, shape = RoundedCornerShape(20.dp) )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultAddPlanStepMarkerPreview() {
    AddPlanStepMarker()
}