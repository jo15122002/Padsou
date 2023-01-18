package com.example.padsou.ui.shared

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.data.models.User
import com.example.padsou.data.store.UserStore
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.LightYellow
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.Placeholder
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.firstOrNull
import java.util.Objects.toString


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

@Composable fun Email(email: String, error: String?, haveInfo: Boolean = false, placeholder: String = "Ton adresse e-mail" , title: String = "", onEmailChanged : (String) -> Unit){

    Column{
        Text(title, modifier = Modifier.padding(bottom = 7.dp), style = MaterialTheme.typography.h4)
        OutlinedTextField(
            value = email,
            onValueChange = {string -> onEmailChanged(string)},
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White),
            isError = error != null
        )
        error?.let{ ErrorField(it) }
    }
}

@Composable fun Password(password : String, error :String?, onPasswordChanged : (String) -> Unit){
    Column{
        OutlinedTextField(
            value = password,
            onValueChange = {string -> onPasswordChanged(string)},
            placeholder = { Text("Ton mot de passe") },
            shape = RoundedCornerShape(15.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White),
            isError = error != null
        )
        error?.let{ ErrorField(it) }
    }
}

@Composable fun InputFieldWithTitle(input: String, error: String?, placeholder:String, title : String, height: Dp = 56.dp, onInputChanged : (String) -> Unit){
    Column{
        Text(title, modifier = Modifier.padding(bottom = 7.dp), style = MaterialTheme.typography.h4)
        OutlinedTextField(
            value = input,
            onValueChange = {string -> onInputChanged(string)},
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White),
            isError = error != null
        )
        error?.let{ ErrorField(it) }
    }
}
@Composable fun HyperlinkFieldWithTitle(input: String, error: String?, placeholder:String, title : String, height: Dp = 56.dp, onInputChanged : (String) -> Unit){
    Column{
        Text(title, modifier = Modifier.padding(bottom = 7.dp), style = MaterialTheme.typography.h4)
        OutlinedTextField(
            value = input,
            onValueChange = {string -> onInputChanged(string)},
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MainPurple,unfocusedBorderColor = Color.White),
            isError = error != null
        )
        error?.let{ ErrorField(it) }
    }
}

@Composable
fun ErrorField(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(color= MaterialTheme.colors.error)
    )
}


@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    TextInput(placeholder = { Text("Un titre") })
}