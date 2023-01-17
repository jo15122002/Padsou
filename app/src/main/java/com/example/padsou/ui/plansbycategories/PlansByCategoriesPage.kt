package com.example.padsou.ui.plansbycategories

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.data.models.Category
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.Layout
import com.example.padsou.ui.shared.ListPlanProfile
import com.example.padsou.ui.shared.PlanProfile
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import kotlin.math.ceil


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlansByCategoriesPage(navigateBack: () -> Unit, viewModel: PlansByCategoriesViewModel){

    val category: State<Category> = viewModel.category.collectAsState()
    val plans: State<List<Plan>> = viewModel.plans.collectAsState()

    val context = LocalContext.current
    val drawableId = context.resources.getIdentifier(
        "ic_baseline_arrow_back_24",
        "drawable",
        context.packageName
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(category.value.getColor())
    ) {
        item{
            Row(
                modifier = Modifier
                    .padding(20.dp, 30.dp)
                    .clickable {
                        navigateBack()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = drawableId),
                    contentDescription = "Navigate back",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Text(category.value.name, color = Color.White, style = MaterialTheme.typography.h3)
            }
        }
        item{
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight()
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                    .background(BackgroundWhite)
                    .padding(28.dp, 30.dp)
            ) {
                Log.d("viewModel", "plans.value.size ${plans.value.size}")
                ListPlanProfile(plans.value, onPlanClick = {})
            }
        }

    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPlansByCategoriesPagePreview() {
    PlansByCategoriesPage(navigateBack = { }, PlansByCategoriesViewModel())
}