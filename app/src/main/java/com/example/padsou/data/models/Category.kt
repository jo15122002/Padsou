package com.example.padsou.data.models;

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.core.content.res.ResourcesCompat
import com.example.padsou.R
import com.example.padsou.ui.theme.CourseColor

class Category (var name: String, var color: Color, var iconUrl: String){


    companion object {
        fun defaultCategory(): Category{
            return Category(
                "Sport",
                CourseColor,
                "ic_sport"
            )
        }
    }

    fun getIcon(): Int {
        return R.drawable.ic_sport
    }
}
