package com.example.padsou.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.example.padsou.R

val intergralCF = FontFamily(
    Font(R.font.integralcf_regular),
    Font(R.font.integralcf_bold, weight = FontWeight.Bold),
    Font(R.font.integralcf_demi_bold, weight = FontWeight.SemiBold),
    Font(R.font.integralcf_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.integralcf_medium, weight = FontWeight.Medium),
    Font(R.font.integralcf_heavy, weight = FontWeight.Black),

    Font(R.font.integralcf_regular_oblique, weight = FontWeight.Normal, style = FontStyle.Italic),
)

// Set of Material typography styles to start with
val IntergralCFTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle( // ex: PAS DE SOUS ? IL Y A PADSOU on onboarding page
        fontFamily = intergralCF,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle( // ex: Bienvenue on Register page
        fontFamily = intergralCF,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    h3 = TextStyle( // ex: inscrit toi ... on Register page
        fontFamily = intergralCF,
        fontWeight= FontWeight.Normal,
        fontSize = 18.sp
    ),



)

