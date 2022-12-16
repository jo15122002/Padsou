package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TextInput(placeholder:String){
    var inputText by remember { mutableStateOf("") }
    Column() {
        OutlinedTextField(value = inputText, onValueChange = { inputText = it }, placeholder = {Text(placeholder)})
    }
}


@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    TopPageTitle("Un titre", "Un sous-titre")
}