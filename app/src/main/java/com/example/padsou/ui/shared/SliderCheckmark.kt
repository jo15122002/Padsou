package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderCheckmark(filled:Boolean = false, color: Color = Color.White){

    Box(
        Modifier
            .height(5.dp)
            .width(25.dp)
            .then(if(!filled)
                Modifier.background(color = color.copy(alpha = 0.4f), shape = RoundedCornerShape(20.dp) )
            else
                Modifier.background(color = color, shape = RoundedCornerShape(20.dp) )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultOnBoardingPreview() {
    SliderCheckmark()
}