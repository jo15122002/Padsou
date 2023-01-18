package com.example.padsou.ui.SignUp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.TextGray
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignUpView(onNavigateToSignIn : ()->Unit, onNavigateToPlans : ()->Unit){

    val context = LocalContext.current
    val dataStore = UserStore(context)

    val email = remember { EmailState() }
    val password = remember { PasswordState() }
    val rememberMe = remember { mutableStateOf(false) }

    LaunchedEffect(Unit){
        val storeEmail = dataStore.getEmail.firstOrNull()
        val storePassword = dataStore.getPassword.firstOrNull()
        val storeOption = dataStore.getOption.firstOrNull()

        if(storeOption == true){
            val user = User(storeEmail?: "", storePassword ?: "");
            user.verifyLogin(onNavigateToPlans, context) {};
        }

        email.text = storeEmail?: ""
        password.text = storePassword ?: ""
        rememberMe.value = storeOption ?: false
    }

    Column(
        Modifier
            .background(BackgroundWhite)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 80.dp, bottom = 63.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text("Te revoilà ! 🔥", style = MaterialTheme.typography.h1)
        Text("Reviens vite pour profiter des bons plans",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 72.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )

        Box() {
            Column(
                modifier = Modifier
                    .padding(vertical = 60.dp, horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {

                Email(email.text, email.error){
                    email.text = it
                    email.validate(null)
                }

                Password(password.text, password.error){
                    password.text = it
                    password.validate(null)
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                    Text("Se souvenir de moi")
                    Checkbox(
                        checked = rememberMe.value,
                        onCheckedChange = { rememberMe.value = it },
                        enabled = true,
                        colors = CheckboxDefaults.colors(MainPurple)
                    )
                }
            }
        }

        Text("Mot de passe oublié ?",
            modifier =
            Modifier
                .padding(start = 35.dp, end = 35.dp, bottom = 12.dp)
                .align(Alignment.End)
            ,

            color = TextGray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold

        )

        Box(){
            val context = LocalContext.current
            SignUpButton(enabled = email.isValid() && password.isValid(), email.text ,password.text,rememberMe.value,  onNavigateToPlans, context, dataStore)
        }



        Row(
            Modifier.padding(top = 120.dp)
        ) {
            Text("Pas encore inscrit ? ", color = TextGray, fontWeight = FontWeight.Bold)
            Text("Allez viens !",Modifier.clickable { onNavigateToSignIn() }, color = MainPurple, fontWeight = FontWeight.Bold)
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SignUpViewPreview() {
    SignUpView(onNavigateToSignIn = {}, onNavigateToPlans = {})
}