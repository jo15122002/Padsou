package com.example.padsou.ui.allplans

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Plan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllPlansViewModel: ViewModel() {

    private val _plans = MutableStateFlow<List<Plan>>(listOf())
    val plans = _plans.asStateFlow()

    private val _isLoaded = MutableStateFlow(false)
    val isLoaded = _isLoaded.asStateFlow()

    init {
        Log.d("allPlans", "init all plan view model")
        Manager.getPlans { items ->
            _plans.value = items
            _isLoaded.value = true
            Log.d("allPlans", "responde $items")

        }
    }
}