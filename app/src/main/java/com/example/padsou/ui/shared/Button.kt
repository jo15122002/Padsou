package com.example.padsou.ui.shared

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.User
import com.example.padsou.ui.theme.MainPurple
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import java.util.*
import java.util.logging.Handler

@Composable
fun SignInButton(enabled: Boolean, email: String, password:String, navigator: ()->Unit, context: android.content.Context ){
    Button(
        onClick = {
            val userToAdd = User(email, password)
            userToAdd.addNewUser(navigator, context)
        },
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(horizontal = 90.dp, vertical = 18.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MainPurple,
            contentColor = Color.White
        ),
        enabled = enabled
    ) {
        Text(text = "S'inscrire",
            color = Color.White,
            style = MaterialTheme.typography.h3)
    }
}

@Composable
fun SignUpButton(enabled: Boolean, email: String, password: String, navigator: ()->Unit, context: android.content.Context){
    Button(
        onClick = {
            val user = User(email, password);
            user.verifyLogin(navigator, context);
        },

        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(horizontal = 90.dp, vertical = 18.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MainPurple,
            contentColor = Color.White
        ),
        enabled = enabled
    ) {
        Text(text = "Se connecter",
            color = Color.White,
            style = MaterialTheme.typography.h3)
    }
}