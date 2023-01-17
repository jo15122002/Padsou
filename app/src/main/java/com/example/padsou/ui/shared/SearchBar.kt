package com.example.padsou.ui.shared

import android.util.Log
import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.MainPurple
import kotlinx.coroutines.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(placeholder:@Composable ()->Unit, height: Dp = 56.dp, onSearch: (value: String)->Unit, setLoaded: (value:Boolean)->Unit){

    var inputText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    fun handleChange(newValue: String) {
        inputText = newValue
        onSearch(inputText)
    }

    fun search(){
        keyboardController?.hide()
        focusManager.clearFocus()
        onSearch(inputText)
    }

    fun clear(){
        inputText = ""
        search()
    }

    OutlinedTextField(value = inputText, onValueChange = { handleChange(it) }, placeholder = placeholder,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White),
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White),
        trailingIcon = {
            if(inputText.isNotEmpty()){
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier
                        .clickable {
                            clear()
                        }
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {search()})
    )
}