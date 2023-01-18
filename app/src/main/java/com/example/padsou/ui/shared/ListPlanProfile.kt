package com.example.padsou.ui.shared

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Plan
import kotlin.math.ceil


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListPlanProfile(plans: List<Plan>, onPlanClick: (id: String)->Unit){


    var size = ceil((plans.size / 2).toDouble())
    if(plans.size >= 3) size += 1
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
                    PlanProfile(plan, true, onPlanClick)
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultListPlanProfilePreview() {
    ListPlanProfile(listOf(), onPlanClick = {})
}