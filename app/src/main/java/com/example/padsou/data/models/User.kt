package com.example.padsou.data.models

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.text.substring
import com.example.padsou.data.managers.Manager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

data class User(var email: String, var password: String, val username: String = "" , val adress: String = "") {

    constructor() : this(defaultUser().email, defaultUser().password, defaultUser().adress)

    companion object {
        fun defaultUser(): User{
            return User("romain.lucas@lerperlier.com", "joyce", "romain.lucas", "156 route de vache, Paris")
        }
    }

    fun addNewUser(navigator: ()->Unit, context: android.content.Context){
        val db = Firebase.firestore
        val userRef = db.collection("users")

        userRef.whereEqualTo("email", this.email)
            .get()
            .addOnSuccessListener { users ->
                if(users.count() == 0){
                    val username = this.email.substringBefore('@')
                    val userToAdd = User(this.email, this.password, username)
                    userRef.add(userToAdd)
                        .addOnSuccessListener {
                            Manager.user = userToAdd;
                            navigator()
                            Toast.makeText(context, "Bienvenue mon pote 😁", Toast.LENGTH_LONG).show()
                        }
                }
                else{
                    Toast.makeText(context, "Un compte avec cette adresse a déjà été crée", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun verifyLogin(navigator: ()->Unit, context: android.content.Context){
        val db = Firebase.firestore
        val allUsers = db.collection("users")

        allUsers
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { users ->
                if (users.count() > 0){
                    Manager.user = users.first().toObject<User>()
                    navigator()
                    Toast.makeText(context, "Connexion réussi 🔥", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(context, "Aucun compte avec ces identifiants n'a été trouvé", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun modifyUser(context: android.content.Context){
        val db = Firebase.firestore
        val allUsers = db.collection("users")
    }

}


