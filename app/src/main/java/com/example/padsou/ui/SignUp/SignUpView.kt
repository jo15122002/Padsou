package com.example.padsou.ui.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.ui.shared.TextInput
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.TextGray

@Composable
fun SignUpView(){

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
                    .padding(vertical = 60.dp),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                TextInput(placeholder = "Ton adresse e-mail")
                TextInput(placeholder = "Ton mot de passe")
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

        Box(modifier = Modifier
            .clickable { }
            .align(Alignment.CenterHorizontally)
            .background(
                MainPurple,
                shape = RoundedCornerShape(18.dp)
            )
            .padding(horizontal = 90.dp, vertical = 18.dp))

        {
            Text("S'inscrire",
                color = Color.White,
                style = MaterialTheme.typography.h3)
        }

        Row(
            Modifier.padding(top = 120.dp)
        ) {
            Text("Déjà un compte ? ", color = TextGray, fontWeight = FontWeight.Bold)
            Text("Connecte-toi !", color = MainPurple, fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpViewPreview() {
    SignUpView()
}