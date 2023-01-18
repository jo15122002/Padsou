package com.example.padsou.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.CategoryProfile
import com.example.padsou.ui.shared.ListPlanProfile
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.SeeMore
import java.util.Locale.Category


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DefaultHomeView(viewModel: HomeViewModel, onCategoryClick: (id: String)->Unit, onPlanClick: (id: String)->Unit, onVoirTout: ()->Unit){

    val categories: State<List<com.example.padsou.data.models.Category>> = viewModel.categories.collectAsState()
    val plans: State<List<Plan>> = viewModel.plans.collectAsState()

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        categories.value.map { c ->
            CategoryProfile(c, onCategoryClick)
        }
    }
    Spacer(modifier = Modifier.height(39.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Les plans du moments", style = MaterialTheme.typography.h4)
        Text(
            "Voir tout",
            color = SeeMore,
            fontWeight = FontWeight.W700,
            modifier = Modifier.clickable {
                onVoirTout()
            })
    }
    ListPlanProfile(plans.value, onPlanClick)
}
