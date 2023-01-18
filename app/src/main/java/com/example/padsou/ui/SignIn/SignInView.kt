package com.example.padsou.ui.SignIn

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.data.store.UserStore
import com.example.padsou.ui.shared.*
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.TextGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignInView(onNavigateToHome: () -> Unit, onNavigateToSignUp: () -> Unit){

    val context = LocalContext.current
    val dataStore = UserStore(context)

    Column(
        Modifier
            .background(BackgroundWhite)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 80.dp, bottom = 63.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text("Bienvenue 😎", style = MaterialTheme.typography.h1)
        Text("Inscris-toi pour avoir les meilleurs plans étudiants !",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 72.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )


        val email = remember { EmailState() }
        val password = remember { PasswordState() }
        val passwordToVerifie = remember{ VerifyPasswordState() }

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

                Password(passwordToVerifie.text, passwordToVerifie.error){
                    passwordToVerifie.text = it
                    passwordToVerifie.validate(password.text)
                }

            }
        }

        Text("En t’inscrivant, tu acceptes les Conditions générales d’utilisation de Padsou",
            modifier = Modifier.padding(start = 35.dp, end = 35.dp, bottom = 12.dp) ,
            color = TextGray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Box(){
            val context = LocalContext.current
            SignInButton(enabled = email.isValid() && password.isValid() && passwordToVerifie.text == password.text, email.text, password.text, onNavigateToHome, context, dataStore)

        }

        Row(
            Modifier.padding(top = 120.dp)
        ) {
            Text("Déjà un compte ? ", color = TextGray, fontWeight = FontWeight.Bold)
            Text("Connecte-toi !",Modifier.clickable { onNavigateToSignUp() }, color = MainPurple, fontWeight = FontWeight.Bold)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SignInViewPreview() {
    SignInView(onNavigateToHome = {}, onNavigateToSignUp = {})
}

private fun saveUserData(){

}
