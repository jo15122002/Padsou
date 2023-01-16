package com.example.padsou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.theme.IntergralCFTypography
import com.example.padsou.ui.shared.PadsouNavHost

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