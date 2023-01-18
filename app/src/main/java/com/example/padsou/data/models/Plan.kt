package com.example.padsou.data.models

import android.util.Log
import com.example.padsou.data.managers.Manager
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Plan(
    var id:String,
    var title: String = "",
    var description: String = "",
    var photoUrl: String = "",
    var logoUrl: String = "",
    var link:String = "",
    var userId: String = "",
    var categoryId:String = "",
    var base64Images:List<String> = listOf(),
    var utilisationCount:Int=0
    ){

    constructor() : this(defaultPlan().id, defaultPlan().title, defaultPlan().description, defaultPlan().photoUrl, defaultPlan().logoUrl, defaultPlan().link, defaultPlan().userId,defaultPlan().categoryId, defaultPlan().base64Images)

    companion object {
        fun defaultPlan(): Plan{
            return Plan(
                (0..1000000).random().toString(),
                "Default plan",
                "2 tacos offerts",
                "https://www.maspatule.com/blog/wp-content/uploads/2021/07/IMG_4190-2-800x1067.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/a/a3/Basic-Fit_logo.png",
                "https://www.maspatule.com/blog/2021/07/26/recette-tacos-mexicain/",
                "479iX3fq0PkPTgPbCkZU",
                "0",
                listOf("test", "test"),
            )
        }
    }

    override fun toString(): String {
        return "Plan(title='$title')"
    }

    fun updateUtilisationCount(count : Int){
        var db = Firebase.firestore
        var tablePlan = db.collection("plans")
        tablePlan.document(this.id).update("utilisationCount", count)
    }
}