package com.example.padsou

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun popUpNotificationDisabled(){
    val openDialog = remember { mutableStateOf(true) }

    AlertDialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = true
        ),
        title = { Text("C'est noté 👍") },
        text = {
            Text("On t'enverra pas de notifications. Si jamais l'envie t'en prend, tu peux toujours les réactiver dans les réglage ❤")
        },
        onDismissRequest = { openDialog.value = true },
        confirmButton = {
            Button(
                onClick = {
                    openDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(Color(0xffFF9800))
            ) {
                Text(text = "Continuer sur l'app")
            }
        }
    )
}