package com.example.padsou.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.data.models.Category


@Composable
fun CategoryProfile(category: Category = Category.defaultCategory(), onCategoryClick: (String)->Unit){

    val context = LocalContext.current
    val drawableId = context.resources.getIdentifier(
        category.iconUrl,
        "drawable",
        context.packageName
    )

    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
               onCategoryClick(category.id)
           }
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
        Box(
            modifier = Modifier
                .size(57.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(category.getColor()),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(drawableId),
                contentDescription = category.iconUrl,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(category.name,
            style = MaterialTheme.typography.h5,
            color = category.getColor()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryProfilePreview() {
    CategoryProfile(onCategoryClick = { })
}