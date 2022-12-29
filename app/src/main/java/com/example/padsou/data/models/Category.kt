package com.example.padsou.data.models;

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.padsou.R

class Category (var name: String, var color: String, var iconUrl: String){


    companion object {
        fun defaultCategory(): Category{
            return Category(
                "Sport",
                "#605DF5",
                "ic_sport"
            )
        }
    }

    fun getIcon(): Int {

        val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable., null)
    }
}
