package com.example.padsou.data.database

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

object Database{

    private var db = Firebase.firestore

    fun loadHomePageData(){
        //getAllCategory()
    }

    fun getAllCategory(onSuccess : (MutableList<Category>)->Unit) = GlobalScope.async {
        val items = mutableListOf<Category>()
        db.collection("category")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val localCategory = document.toObject<Category>()
                    items.add(localCategory)
                    Log.d("ViewModel", "DocumentSnapshot localCategory: $localCategory")
                }
                onSuccess(items)
            }
            .addOnFailureListener { }
    }

    fun getAllPlan(onSuccess : (MutableList<Plan>)->Unit) = GlobalScope.async {
        val items = mutableListOf<Plan>()
        db.collection("plans")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val localPlan = document.toObject<Plan>()
                    items.add(localPlan)
                    Log.d("ViewModel", "DocumentSnapshot localPlan: $localPlan")
                }
                onSuccess(items)
            }
            .addOnFailureListener { }
    }


}