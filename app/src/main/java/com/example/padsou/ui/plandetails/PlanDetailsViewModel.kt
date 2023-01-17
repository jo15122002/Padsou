package com.example.padsou.ui.plandetails

import androidx.lifecycle.ViewModel
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlanDetailsViewModel:ViewModel()
{
    private val _plan = MutableStateFlow<Plan>(Plan())
    val plan = _plan.asStateFlow()

    fun setPlanId(id: String){
        Manager.getPlan(id, onGet = {
            _plan.value = it
        })
    }
}