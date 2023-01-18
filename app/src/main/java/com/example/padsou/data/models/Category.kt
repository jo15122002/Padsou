package com.example.padsou.data.models;

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

class Category (var id:String, var name: String, var color: String, var iconUrl: String){

    constructor() : this(defaultCategory().id, defaultCategory().name, defaultCategory().color, defaultCategory().iconUrl)

    companion object {
        fun defaultCategory(): Category{
            return Category(
                (0..1000000).random().toString(),
                "soon",
                "#BFC0DF",
                "ic_soirees"
            )
        }
    }

    fun getColor():Color{
        return Color(this.color.toColorInt())
    }

    override fun toString(): String {
        return "Category(name='$name')"
    }


}
