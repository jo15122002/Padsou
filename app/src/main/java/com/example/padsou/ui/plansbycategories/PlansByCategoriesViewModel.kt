package com.example.padsou.ui.plansbycategories

import androidx.lifecycle.ViewModel
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlansByCategoriesViewModel: ViewModel() {

    private val _category = MutableStateFlow(Category.defaultCategory())
    val category = _category.asStateFlow()

    private val _plans = MutableStateFlow<List<Plan>>(listOf())
    val plans = _plans.asStateFlow()

    fun setCategoryId(id: String){
        Manager.getCategory(id, onGet = {
            _category.value = it
            getPlans(it.id)
        })
    }

    private fun getPlans(categoryId: String){
        Manager.getPlans { plans ->
            val temp = plans.filter { it.categoryId == categoryId}
            _plans.value = temp
        }
    }

}