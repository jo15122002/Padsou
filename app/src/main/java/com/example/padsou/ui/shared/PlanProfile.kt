package com.example.padsou.ui.shared

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.Plan
import com.example.padsou.data.models.User
import com.example.padsou.ui.theme.TextBlack
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase

@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanProfile(
    plan: Plan = Plan.defaultPlan(),
    isBig: Boolean = false,
    onPlanClick: (id: String)->Unit
){
    var height = 105.dp
    if(isBig) height = 150.dp

    val db = Firebase.firestore

    var logo by remember { mutableStateOf("") }

    Manager.getUser(plan.userId, onGet = { user ->
        logo = user.profilePic
    })

    val imageModifier = Modifier
        .then(
            if (isBig)
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(height * 3 / 5)
            else
                Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .height(height / 2)
        )
        .fillMaxSize()

    Card(
        modifier = Modifier
            .clickable {
                onPlanClick(plan.id)
            }
            .padding(4.dp)
            .height(height)
            .then(
                if (isBig)
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                else
                    Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .width(100.dp)

            ),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(7.dp)) {
            Box(
                contentAlignment = Alignment.BottomCenter,
            ) {
                Box(
                    Modifier
                        .padding(bottom = 15.dp)
                ) {
                    if(!plan.base64Images.isEmpty() && plan.base64Images[0].startsWith("/9j/")){
                        Image(
                            bitmap = ImageManager.decodeBase64ToImageBitmap(plan.base64Images[0]),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    }else{
                        AsyncImage(
                            model = plan.photoUrl,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier)
                    }
                }
                Card(
                    shape = CircleShape,
                    elevation = 0.dp,
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(3.dp),
                ) {
                    AsyncImage(
                        model = plan.logoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                    if(plan.userId.isNotEmpty() && logo.isNotEmpty() && logo != null && logo != "null"){
                        Image(
                            bitmap = ImageManager.decodeBase64ToImageBitmap(logo),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .then(
                                    if (isBig)
                                        Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .height(height * 3 / 5)
                                    else
                                        Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .height(height / 2)
                                )
                                .fillMaxSize()
                        )
                    }else if(!plan.logoUrl.isEmpty()){
                        AsyncImage(
                            model = plan.logoUrl.toString(),
                            contentDescription = "")
                    }else{
                        Image(
                            bitmap = ImageManager.decodeBase64ToImageBitmap(User.defaultUser().profilePic),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .then(
                                    if (isBig)
                                        Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .height(height * 3 / 5)
                                    else
                                        Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .height(height / 2)
                                )
                                .fillMaxSize()
                        )
                    }
                }
            }
            Column(Modifier.padding(horizontal = 10.dp)) {

                Text(text = plan.title, style = TextStyle(color = TextBlack, fontWeight = FontWeight.W700, fontSize = 11.sp))
                Text(text = plan.description, style = TextStyle(color = TextBlack, fontSize = 7.sp))
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPlanProfilePreview() {
    PlanProfile(onPlanClick = {})
}