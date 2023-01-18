package com.example.padsou.ui.add_plan

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Plan
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*

object AddPlanPhotoPageViewModel : ViewModel(){

    private val _selectedImages: MutableStateFlow<List<Uri>> = MutableStateFlow<List<Uri>>(listOf())

    var plan = Plan();

    val selectedImages = _selectedImages.asStateFlow()

    var db = Firebase.firestore

    fun changeSelectedImages(list : List<Uri>){
        viewModelScope.launch {
            _selectedImages.emit(list)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun encodeImageListToBase64(context : Context, list : List<Uri>){
        this.plan.base64Images = ImageManager.encodeImageUriListToBase64(list, context)
    }

    fun uploadPlan(onSuccess : () -> Unit){
        this.plan.logoUrl = ""
        this.plan.photoUrl = ""
        db.collection("plans").add(this.plan).addOnSuccessListener {
            Manager.loadPlans {
                onSuccess()
            }
        }
    }
}