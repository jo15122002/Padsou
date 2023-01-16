package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.padsou.data.database.Database
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _categories = MutableStateFlow<MutableList<Category>>(mutableListOf())
    val categories = _categories.asStateFlow()

    private val _isLoadedCategory = MutableStateFlow(false)
    val isLoadedCategory = _isLoadedCategory.asStateFlow()

    private val _plans = MutableStateFlow<MutableList<Plan>>(mutableListOf())
    val plans = _plans.asStateFlow()

    private val _isLoadedPlan = MutableStateFlow(true)
    val isLoadedPlan = _isLoadedPlan.asStateFlow()


    init {
        Log.d("ViewModel", "Loading cate")
        loadCategories()
        loadPlans()
    }

    private fun loadCategories(){
        viewModelScope.launch{
            Database.getAllCategory(onSuccess = { items ->
                _categories.value = items
                _isLoadedCategory.value = true
                Log.d("ViewModel", "Updated cate : $items")
            })
        }
    }

    private fun loadPlans(){
        viewModelScope.launch{
            Database.getAllPlan(onSuccess = { plans ->
                _plans.value = plans
                _isLoadedPlan.value = true
                Log.d("ViewModel", "Updated plans : $plans")
            })
        }
    }



}