package com.example.padsou.ui.add_plan

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Space
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.padsou.ui.shared.AddPlanStepMarker
import com.example.padsou.ui.shared.TopPageTitle
import com.example.padsou.ui.theme.BackgroundWhite
import com.example.padsou.ui.theme.MainPurple
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.padsou.ui.shared.Layout
import com.google.common.cache.Weigher
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.internal.wait
import java.io.ByteArrayOutputStream
import java.util.*


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AddPlanPhotoPage(navController : NavHostController){
    Layout(content = { AddPlanPhotoContentPage(navController = navController) }, navController = navController)
}



@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AddPlanPhotoContentPage(navController : NavHostController){
    val viewModel = AddPlanPhotoPageViewModel
    val context = LocalContext.current
    val selectedImages : State<List<Uri>> = viewModel.selectedImages.collectAsState()

    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetMultipleContents(), onResult = {
        uriList ->

        viewModel.changeSelectedImages(uriList)
    })



    Column(modifier =
    Modifier
        .background(MainPurple)
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        TopPageTitle("Ajouter", "Un bon plan pour en faire profiter les autres")
        Column (modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(BackgroundWhite)
            .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.height(27.dp))
            Row() {
                AddPlanStepMarker(filled = true)
                Spacer(modifier = Modifier.width(12.dp))
                AddPlanStepMarker(filled = false)
            }
            Spacer(modifier = Modifier.height(27.dp))
            Column(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "PHOTO DU BON PLAN", style = MaterialTheme.typography.h4, modifier = Modifier.padding(top = 20.dp, bottom = 26.dp))
                Box(modifier = Modifier
                    .background(MainPurple, shape = RoundedCornerShape(18.dp))
                    .width(174.dp)
                    .aspectRatio(1f)
                    .clickable {
                        galleryLauncher.launch("image/*")
                    },
                    contentAlignment = Alignment.Center,
                ){
                    Text("+", fontSize = 65.sp, color = Color.White)
                }
                LazyVerticalGrid(cells = GridCells.Fixed(3)) {
                    items(selectedImages.value.size){index ->
                        if(selectedImages.value.isNotEmpty()){
                            Image(
                                painter = rememberAsyncImagePainter(selectedImages.value[index]),
                                contentScale = ContentScale.FillWidth,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(16.dp, 8.dp)
                                    .size(100.dp)
                                    .clickable {

                                    }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier
                    .background(MainPurple, shape = RoundedCornerShape(18.dp))
                    .width(313.dp)
                    .height(70.dp)
                    .clickable {
                        viewModel.encodeImageListToBase64(
                            context,
                            selectedImages.value
                        )
                        viewModel.uploadPlan{
                            Toast.makeText(context, "Ton plan à bien été enregistré 👌", Toast.LENGTH_LONG).show()
                            navController.navigate("home")
                        }
                    }
                    ,
                    contentAlignment = Alignment.Center
                    ) {
                    Text("Ajouter ce bon plan", color = Color.White, style = MaterialTheme.typography.h3)
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun DefaultAddPlanPhotoPagePreview() {
    AddPlanPhotoPage(rememberNavController())
}