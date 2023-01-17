package com.example.padsou.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.ListPlanProfile
import com.example.padsou.ui.theme.MainPurple


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeSearchView(viewModel: HomeViewModel){

    val searchPlans: State<List<Plan>> = viewModel.searchPlans.collectAsState()

    ListPlanProfile(searchPlans.value, onPlanClick = {})

}