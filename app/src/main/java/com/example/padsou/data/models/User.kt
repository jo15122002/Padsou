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

data class User(var id : String, var email: String, var password: String, var username: String = "" , var adress: String = "") {

    constructor(email: String, password: String) : this(defaultUser().id, email, password)
    constructor() : this(defaultUser().id,defaultUser().email, defaultUser().password)

    companion object {
        fun defaultUser(): User{
            return User("fnjgihjege2gnj3154","romain.lucas@lerperlier.com", "joyce", "romain.lucas", "")
        }
    }

    fun addNewUser(navigator: ()->Unit, context: android.content.Context){
        val db = Firebase.firestore
        val userRef = db.collection("users")

        userRef.whereEqualTo("email", this.email)
            .get()
            .addOnSuccessListener { users ->
                if(users.isEmpty){
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
            .whereEqualTo("email", this.email)
            .whereEqualTo("password", this.password)
            .get()
            .addOnSuccessListener { users ->
                if (!users.isEmpty){
                    Manager.user = users.first().toObject<User>()
                    Manager.user?.id = users.first().id
                    Log.d("***", Manager.user!!.id)
                    navigator()
                    Toast.makeText(context, "Connexion réussi 🔥", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(context, "Aucun compte avec ces identifiants n'a été trouvé", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun modifyUser(newEmail : String?, newUsername : String?, newAdress : String? ,context: android.content.Context){
        val db = Firebase.firestore
        val allUsers = db.collection("users")

        val userEmailUpdateQuery = allUsers.document(this.id).update("email", newEmail.toString())
        val userUsernameUpdateQuery = allUsers.document(this.id).update("username", newUsername.toString())
        val userAdressUpdateQuery = allUsers.document(this.id).update("adress", newAdress.toString())

        allUsers
            .whereEqualTo("password", this.password)
            .get()
            .addOnSuccessListener { users ->
                if(!users.isEmpty){
                        if(newEmail != null){
                            userEmailUpdateQuery.addOnSuccessListener {
                                Manager.user?.email = newEmail.toString();
                                Toast.makeText(context, "Données mise à jour ✌", Toast.LENGTH_LONG).show()
                        }

                        if(newUsername != null){
                            userUsernameUpdateQuery.addOnSuccessListener{
                                Manager.user?.username = newUsername.toString();
                            }
                        }

                        if(newAdress != null){
                            userAdressUpdateQuery.addOnSuccessListener{
                                Manager.user?.adress = newAdress.toString();
                            }
                        }
                    }
                }
            }
    }

}


