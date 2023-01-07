package com.example.padsou.ui.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple


@Composable
fun TextInput(placeholder:@Composable ()->Unit, height: Dp = 56.dp){
    var inputText by remember { mutableStateOf("") }
    OutlinedTextField(value = inputText, onValueChange = { inputText = it }, placeholder = placeholder,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White),
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White)
    )
}


@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    TextInput(placeholder = { Text("Un titre") })
}