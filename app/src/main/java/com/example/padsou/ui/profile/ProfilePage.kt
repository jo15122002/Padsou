package com.example.padsou.ui.profile

import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.data.managers.ImageManager
import com.example.padsou.data.managers.Manager
import com.example.padsou.data.models.User
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfilePage(){

    val context = LocalContext.current
    val username = remember { InputState() }
    val email = remember { EmailState() }
    val localisation = remember { InputState() }
    var profilePic = ImageManager.decodeBase64ToImageBitmap(User.defaultUser().profilePic)
    var newProfilePic by remember { mutableStateOf("") }

    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = {
            uri ->

        newProfilePic = ImageManager.encodeImageUriToBase64String(uri!!, context);

    })

    if(Manager.user != null){
        username.text = Manager.user?.username.toString()
        email.text = Manager.user?.email.toString()
        localisation.text = Manager.user?.adress.toString()
        if (!Manager.user?.profilePic.toString().isEmpty()){
            profilePic = ImageManager.decodeBase64ToImageBitmap(Manager.user?.profilePic.toString())
        }
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
                Image(
                    bitmap = profilePic,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                    .background(Color(0xFFE3E3E3), shape = RoundedCornerShape(100.dp))
                    .width(150.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(75.dp))
                    .clickable {
                        galleryLauncher.launch("image/*")
                    },
                )

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
                    saveAccountModificationButton(enabled = username.isValid() && email.isValid() && (localisation.isValid() || localisation.text == ""), email=email.text, username = username.text, adress = localisation.text , base64ProfilePic = newProfilePic, text = "SAUVGARDER TES INFORMATIONS", context = context )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}