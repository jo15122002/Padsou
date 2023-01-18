package com.example.padsou.ui.plandetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Plan
import com.example.padsou.data.models.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlanDetailsViewModel:ViewModel()
{
    private val _plan = MutableStateFlow<Plan>(Plan())
    val plan = _plan.asStateFlow()
    @RequiresApi(Build.VERSION_CODES.O)
    private val _user = MutableStateFlow<User>(User())
    @RequiresApi(Build.VERSION_CODES.O)
    val user = _user.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun setPlanId(id: String){
        Manager.getPlan(id, onGet = {
            _plan.value = it
            setUser(it.userId)
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setUser(id:String){
        Manager.getUser(id, onGet = {
            _user.value = it
        })
    }


}