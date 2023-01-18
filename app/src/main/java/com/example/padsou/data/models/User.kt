package com.example.padsou.data.models

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.substring
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.managers.Manager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

data class User(var id : String, var email: String, var password: String, var username: String = "" , var adress: String = "", var profilePic:String) {

    @RequiresApi(Build.VERSION_CODES.O)
    constructor(email: String, password: String) : this(defaultUser().id, email, password, profilePic = defaultUser().profilePic)
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(email: String, password: String, username:String) : this(defaultUser().id, email, password, username = username, profilePic = defaultUser().profilePic)
    @RequiresApi(Build.VERSION_CODES.O)
    constructor() : this(defaultUser().email, defaultUser().password)

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun defaultUser(): User{
            return User("fnjgihjege2gnj3154","romain.lucas@lerperlier.com", "joyce", "romain.lucas", "", "/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAQwAABtbnRyUkdCIFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAAAADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlkZXNjAAAA8AAAAHRyWFlaAAABZAAAABRnWFlaAAABeAAAABRiWFlaAAABjAAAABRyVFJDAAABoAAAAChnVFJDAAABoAAAAChiVFJDAAABoAAAACh3dHB0AAAByAAAABRjcHJ0AAAB3AAAADxtbHVjAAAAAAAAAAEAAAAMZW5VUwAAAFgAAAAcAHMAUgBHAEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhZWiAAAAAAAABvogAAOPUAAAOQWFlaIAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z3BhcmEAAAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABYWVogAAAAAAAA9tYAAQAAAADTLW1sdWMAAAAAAAAAAQAAAAxlblVTAAAAIAAAABwARwBvAG8AZwBsAGUAIABJAG4AYwAuACAAMgAwADEANv/bAEMAEAsMDgwKEA4NDhIREBMYKBoYFhYYMSMlHSg6Mz08OTM4N0BIXE5ARFdFNzhQbVFXX2JnaGc+TXF5cGR4XGVnY//bAEMBERISGBUYLxoaL2NCOEJjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY//AABEIArwCvAMBIgACEQEDEQH/xAAbAAEBAAMBAQEAAAAAAAAAAAAAAQIDBQQGB//EADYQAQACAQIEAggHAAEFAQEAAAABAhEDIQQxQXESUQUyM2GBkaGxEyJCcsHR8BRDUmLh8RUj/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAGBEBAQEBAQAAAAAAAAAAAAAAABEBIRL/2gAMAwEAAhEDEQA/AP0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA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")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addNewUser(navigator: ()->Unit, context: android.content.Context, onSuccess: () -> Unit){
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
                            onSuccess()
                        }
                }
                else{
                    Toast.makeText(context, "Un compte avec cette adresse a déjà été crée", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun verifyLogin(navigator: ()->Unit, context: android.content.Context, onSuccess: ()->Unit){
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
                    navigator()
                    Toast.makeText(context, "Connexion réussi 🔥", Toast.LENGTH_LONG).show()
                    onSuccess()
                }
                else{
                    Toast.makeText(context, "Aucun compte avec ces identifiants n'a été trouvé", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun modifyUser(newEmail : String?, newUsername : String?, newAdress : String? , newProfilePic:String, context: android.content.Context){
        val db = Firebase.firestore
        val allUsers = db.collection("users")

        val userEmailUpdateQuery = allUsers.document(this.id).update("email", newEmail.toString())
        val userUsernameUpdateQuery = allUsers.document(this.id).update("username", newUsername.toString())
        val userAdressUpdateQuery = allUsers.document(this.id).update("adress", newAdress.toString())
        val userProfilePicUpdateQuery = allUsers.document(this.id).update("profilePic", newProfilePic)

        allUsers
            .whereEqualTo("email", this.email)
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
                            println("***" + newProfilePic)
                        if(!newProfilePic.isEmpty()){
                            userProfilePicUpdateQuery.addOnSuccessListener{
                                Manager.user?.profilePic = newProfilePic;
                            }
                        }
                    }
                }
            }
    }

}


