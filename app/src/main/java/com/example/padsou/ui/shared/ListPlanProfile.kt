package com.example.padsou.ui.shared

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Plan
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.ceil


@Composable
fun ListPlanProfile(plans: List<Plan>){


    var size = ceil((plans.size / 2).toDouble())
    if(size >= 3) size += 1
    if(plans.size <= 1) size += 1
    val temp = plans.chunked(size.toInt())
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        temp.forEach { list ->
            Column(
                Modifier
                    .weight(1f)
            ) {
                list.forEach { plan ->
                    PlanProfile(plan, true)
                }
            }
        }
        if(plans.size == 1){
            Column(
                Modifier
                    .weight(1f)
            ){ }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultListPlanProfilePreview() {
    ListPlanProfile(listOf())
}