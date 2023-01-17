package com.example.padsou.data.managers

import android.util.Log
import androidx.compose.ui.text.toLowerCase
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

    fun getPlans(key:String, onGet: (MutableList<Plan>)->Unit){

        val key = key.lowercase()

        if(plans.value.size == 0){
            loadPlans { items ->
                val temp = items.filter { plan->
                    plan.title.lowercase().contains(key)
                } as MutableList<Plan>
                onGet(temp)
            }
        }else{
            val temp = _plans.value.filter { it.title.lowercase().contains(key) } as MutableList<Plan>
            onGet(temp)
        }
    }

    fun getPlan(id:String, onGet : (Plan)->Unit){
        if(plans.value.size == 0){
            loadPlans { items ->
                val temp = items.first{it.id == id}
                onGet(temp)
            }
        }else{
            val temp = _plans.value.first{it.id == id}
            onGet(temp)
        }
    }

}