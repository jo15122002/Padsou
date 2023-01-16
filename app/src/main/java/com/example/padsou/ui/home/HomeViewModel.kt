package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.padsou.data.database.Database
import com.example.padsou.data.models.Category
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel {

    val categories = mutableStateListOf<Category>()

    fun loadCategory(){
        GlobalScope.launch{
            val res = Database.getAllCategory()
            res.await()
            categories.addAll()
            Log.d("ViewModel", "Updated cate")
        }

    }

}