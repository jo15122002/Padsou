package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.padsou.data.database.Database
import com.example.padsou.data.managers.Manager
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

    private val _showSearchView = MutableStateFlow(false)
    val showSearchView = _showSearchView.asStateFlow()

    private var searchValue = ""

    private val _searchPlans = MutableStateFlow<MutableList<Plan>>(mutableListOf())
    val searchPlans = _searchPlans.asStateFlow()


    init {
        Log.d("ViewModel", "Loading cate")
        loadCategories()
        loadPlans()
    }

    private fun loadCategories(){
        viewModelScope.launch{
            Manager.getCategories { items ->
                _categories.value = items
                _isLoadedCategory.value = true
            }
        }
    }

    private fun loadPlans(){
        viewModelScope.launch{
            Manager.getPlans { items ->
                _plans.value = items
                _isLoadedPlan.value = true
            }
        }
    }

    fun search(value : String){
        searchValue = value
        _isLoadedPlan.value = false

        viewModelScope.launch{
            Manager.getPlans(searchValue) { items ->
                _searchPlans.value = items
                _isLoadedPlan.value = true
            }
        }

        _showSearchView.value = searchValue.isNotEmpty()
    }

    fun setLoadedPlan(value: Boolean){
        if(_isLoadedPlan.value != value) {
            _isLoadedPlan.value = value
        }
    }



}