package com.example.padsou.ui.allplans



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
import androidx.compose.runtime.*
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
import com.example.padsou.data.models.Plan
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.home.DefaultHomeView
import com.example.padsou.ui.home.HomeSearchView
import com.example.padsou.ui.shared.Layout
import com.example.padsou.ui.shared.ListPlanProfile
import com.example.padsou.ui.shared.shimmerBackground
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainCorail


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllPlansPage(navigateBack : ()->Unit, onPlanClick: (id:String)->Unit, viewModel: AllPlansViewModel){

    val plans: State<List<Plan>> = viewModel.plans.collectAsState()
    val isLoaded: State<Boolean> = viewModel.isLoaded.collectAsState()

    val context = LocalContext.current
    val drawableId = context.resources.getIdentifier(
        "ic_baseline_arrow_back_24",
        "drawable",
        context.packageName
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainCorail)
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
                Text("Tout les plans (${plans.value.size})", color = Color.White, style = MaterialTheme.typography.h3)
            }
        }
        if(isLoaded.value){
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(BackgroundWhite)
                        .padding(28.dp, 30.dp)
                ) {
                    ListPlanProfile(plans.value, onPlanClick = onPlanClick)
                }
            }
        }else {
            item{
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(BackgroundWhite)
                        .padding(28.dp, 30.dp)
                ) {
                    Box(
                        Modifier
                            .height(15.dp)
                            .fillMaxWidth()
                            .shimmerBackground(RoundedCornerShape(4.dp))
                    )
                }
            }
        }

    }


}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultAllPlansPagePreview() {
    AllPlansPage(onPlanClick = {}, navigateBack = {}, viewModel = AllPlansViewModel())
}