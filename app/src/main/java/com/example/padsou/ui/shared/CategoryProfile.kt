package com.example.padsou.ui.shared

import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.data.models.Category
import com.example.padsou.ui.theme.CourseColor
import com.example.padsou.ui.theme.MainPurple
import com.example.padsou.ui.theme.Placeholder
import com.google.common.reflect.Reflection.getPackageName


@Composable
fun CategoryProfile(category: Category = Category.defaultCategory()){



    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box(
            modifier = Modifier
                .size(57.dp)
                .background(CourseColor),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(category.getIcon()),
                contentDescription = category.iconUrl
            )
        }
        Text("Sport")
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryProfilePreview() {
    CategoryProfile()
}