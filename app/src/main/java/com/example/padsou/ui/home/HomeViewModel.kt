package com.example.padsou.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.padsou.data.database.Database
import com.example.padsou.data.models.Category
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _categories = MutableStateFlow<MutableList<Category>>(mutableListOf())
    val categories = _categories.asStateFlow()

    private val _isLoaded = MutableStateFlow(false)
    val isLoaded = _isLoaded.asStateFlow()

    init {
        Log.d("ViewModel", "Loading cate")
        loadCategory()
    }

    private fun loadCategory(){
        viewModelScope.launch{
            Database.getAllCategory(onSuccess = { items ->
                _categories.value = items
                _isLoaded.value = true
                Log.d("ViewModel", "Updated cate : $items")
            })
        }
    }


}