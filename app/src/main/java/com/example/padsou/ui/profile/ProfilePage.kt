package com.example.padsou.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.theme.MainPurple
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.User
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.SeeMore


@Composable
fun ProfilePage(){

    val username = remember { InputState() }
    val email = remember { EmailState() }
    val localisation = remember { InputState() }

    if(Manager.user != null){
        username.text = Manager.user?.username.toString()
        email.text = Manager.user?.email.toString()
        localisation.text = Manager.user?.adress.toString()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainPurple)
            .padding(top = 58.dp)

    ) {
        item{
            Column(Modifier.padding(horizontal = 33.dp, vertical = 20.dp)){
                Text("TON COMPTE 😀", color = Color.White, style = MaterialTheme.typography.h1)
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                    .background(BackgroundWhite)
                    .padding(28.dp, 30.dp),
                    verticalArrangement = Arrangement.spacedBy(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier
                    .background(Color(0xFFE3E3E3), shape = RoundedCornerShape(100.dp))
                    .width(150.dp)
                    .aspectRatio(1f)
                    .clickable {
                    },
                    contentAlignment = Alignment.Center,
                ){
                    Text("?", fontSize = 65.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                InputFieldWithTitle(username.text, username.error,"BraddPittOfficial","Pseudo"){
                    username.text = it
                    username.validate(null)
                };

                Email(email.text, email.error, "bradd.pitt@gmail.com", "E-mail"){
                    email.text = it
                    email.validate(null)
                };

                InputFieldWithTitle(localisation.text, localisation.error,"Miraval, 83570 Correns","Localisation"){
                    localisation.text = it
                    localisation.validate(null)
                };

                Box() {
                    val context = LocalContext.current
                    saveAccountModificationButton(enabled = username.isValid() && email.isValid() && (localisation.isValid() || localisation.text == ""), email=email.text, username = username.text, adress = localisation.text ,text = "SAUVGARDER TES INFORMATIONS", context = context )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}