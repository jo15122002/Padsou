package com.example.padsou.data.managers

import android.util.Log
import com.example.padsou.data.database.Database
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import com.example.padsou.data.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object Manager {
    var user : User? = null

    private val _categories = MutableStateFlow<MutableList<Category>>(mutableListOf())
    val categories = _categories.asStateFlow()

    private val _plans = MutableStateFlow<MutableList<Plan>>(mutableListOf())
    val plans = _plans.asStateFlow()

    private fun loadCategories(onGet: (MutableList<Category>)->Unit){
        Database.getAllCategory(onSuccess = { items ->
            _categories.value = items
            onGet(items)
        })
    }

    private fun loadPlans(onGet: (MutableList<Plan>)->Unit){
        Database.getAllPlan(onSuccess = { items ->
            _plans.value = items
            onGet(items)
        })
    }

    fun getCategory(id: String, onGet: (Category)->Unit){
        if(categories.value.size == 0){
            loadCategories(onGet={ items ->
                val c = items.first { it.id == id }
                onGet(c)
            })
        }else{
            val c = _categories.value.first { it.id == id }
            onGet(c)
        }

    }

    fun getCategories(onGet: (MutableList<Category>)->Unit){
        if(categories.value.size == 0){
            loadCategories(onGet)
        }else{
            onGet(_categories.value)
        }
    }

    fun getPlans(onGet: (MutableList<Plan>) -> Unit){
        if(plans.value.size == 0){
            loadPlans(onGet)
        }else{
            onGet(_plans.value)
        }
    }
}