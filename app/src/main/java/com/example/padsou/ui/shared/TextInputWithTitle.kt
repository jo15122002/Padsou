package com.example.padsou.ui.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun TextInputWithTitle(placeholder: String, height: Dp = 56.dp, title: String) {
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