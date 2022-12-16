package com.example.padsou

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                typography = IntergralCFTypography
            ) {
                Column() {
                    Button(onClick = {
                        val user = hashMapOf(
                            "email" to "romain.lentz74@gmail.com",
                            "password" to "test"
                        )

                        db.collection("users")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d("success", "DocumentSnapshot added with ID: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                Log.w("error", "Error adding document", e)
                            }
                    }) {
                        Text("feiboiez")
                    }
                    Text("PAS DE SOUS ?", color = MainPurple, style = MaterialTheme.typography.h1)
                    Text("IL Y A PADSOU", color = MainCorail, fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}