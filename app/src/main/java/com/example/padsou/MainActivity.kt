package com.example.padsou

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.shared.PadsouNavHost
import com.example.padsou.ui.theme.*

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                typography = IntergralCFTypography
            ){
                PadsouNavHost()
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}