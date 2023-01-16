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
fun TextInputWithTitle(placeholder:String, height: Dp = 56.dp, title:String){
    Column() {
        Text(text = title, modifier = Modifier.padding(start = 35.dp, bottom = 7.dp))
        TextInput(placeholder = { Text(text = placeholder) }, height = height)
    }
}


@Preview(showBackground = true)
@Composable
fun TextInputWithTitlePreview() {
    TextInputWithTitle(placeholder = "un placeholder", title = "Un titre d'input")
}