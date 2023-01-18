package com.example.padsou.ui.shared

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import com.example.padsou.ui.onboarding.onBoardingSlider

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.models.Plan
import com.example.padsou.data.models.User
import com.example.padsou.data.static.Screen
import com.example.padsou.ui.theme.MainCorail
import com.example.padsou.ui.theme.MainPurple
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

    var logo = ""

    if(!plan.userId.toString().isEmpty()){
        db.collection("users")
            .document(plan.userId)
            .get()
            .addOnSuccessListener { users->
            var profilePic = users.getField<String>("profilePic")
                if(profilePic.toString() != ""){
                    logo = profilePic.toString()
                }
        }
    }

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

                    if(!plan.userId.isEmpty() && !logo.isEmpty()){
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
                    }else if(!plan.photoUrl.toString().isEmpty()){
                        AsyncImage(
                            model = plan.photoUrl.toString(),
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