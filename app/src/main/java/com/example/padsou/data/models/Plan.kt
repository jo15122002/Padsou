package com.example.padsou.data.models

class Plan (var title: String, var description: String, var photoUrl: String,var logoUrl: String,  var link:String, var userId: String){

    companion object {
        fun defaultPlan(): Plan{
            return Plan("Default plan",
                "Grosse réduction sur les tacos à la gare",
                "https://www.maspatule.com/blog/wp-content/uploads/2021/07/IMG_4190-2-800x1067.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/a/a3/Basic-Fit_logo.png",
                "https://www.maspatule.com/blog/2021/07/26/recette-tacos-mexicain/",
                "0"
            )
        }
    }

}