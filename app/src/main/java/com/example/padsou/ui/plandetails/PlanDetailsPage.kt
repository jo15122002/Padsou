package com.example.padsou.ui.plandetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.models.Plan
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanDetailsPage(viewModel: PlanDetailsViewModel){

    val plan: State<Plan> = viewModel.plan.collectAsState()
    var count by remember { mutableStateOf(plan.value.utilisationCount) }
    val author = viewModel.user.collectAsState()

    val buttonEnabled =  !URLUtil.isValidUrl(plan.value.link)

    val imageModifier = Modifier
        .drawWithCache {
            val gradient = Brush.horizontalGradient(
                colors = listOf(Color.Transparent, Color.Black),
                startX = size.width,
                endX = size.width / 100
            )
            onDrawWithContent {
                drawContent()
                drawRect(gradient, blendMode = BlendMode.Multiply)
            }
        }
        .fillMaxWidth()
        .height(275.dp)

    LazyColumn(
        Modifier
            .background(BackgroundWhite)
            .fillMaxHeight()
    ) {
        item {
            Box(
                Modifier.clip(RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
            ) {
                if(!plan.value.base64Images.isEmpty() && plan.value.base64Images[0].startsWith("/9j/")){
                    Image(bitmap = ImageManager.decodeBase64ToImageBitmap(plan.value.base64Images[0]),
                        contentDescription = "",
                        modifier = imageModifier
                    )
                }else{
                    AsyncImage(
                        model = plan.value.photoUrl,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier)
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 120.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(plan.value.title, color = Color.White, style = MaterialTheme.typography.h2)
                }
            }
        }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 30.dp)

            ){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                ) {
                    Column(
                        Modifier.padding(20.dp)
                    ) {
                        Row(
                            Modifier.padding(bottom = 24.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if(author.value.profilePic.isNotEmpty()){
                                Image(
                                    bitmap = ImageManager.decodeBase64ToImageBitmap(author.value.profilePic),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(30.dp)
                                        .padding(end = 11.dp)
                                        .clip(RoundedCornerShape(15.dp))
                                        .aspectRatio(1f)
                                        .fillMaxSize()
                                )
                            }
                            Column() {
                                Text("Proposé par", fontSize = 10.sp, color = Color(0xFFA6A6A6))
                                Text(author.value.username, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Text(plan.value.description)
                    }
                }
            }

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Testé par ${count} galériens", style = MaterialTheme.typography.h4, textAlign = TextAlign.Center)
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                val uriHandler = LocalUriHandler.current
                Button(
                    onClick = {
                        uriHandler.openUri("http://${plan.value.link}")
                        count ++
                        plan.value.updateUtilisationCount(count)
                    },
                    shape = RoundedCornerShape(15.dp),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 18.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MainPurple,
                        contentColor = Color.White
                    ),
                    enabled = buttonEnabled
                ) {
                    Text(text = "PROFITER DE L'OFFRE",
                        color = Color.White,
                        style = MaterialTheme.typography.h3)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PlanDetailsPagePreview() {
    PlanDetailsPage(PlanDetailsViewModel())
}