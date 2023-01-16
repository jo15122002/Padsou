package com.example.padsou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.shared.PadsouNavHost
import com.example.padsou.ui.theme.*
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                typography = IntergralCFTypography
            ) {
                PadsouNavHost()
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}