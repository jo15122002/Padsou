package com.example.padsou.data.managers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.*

object ImageManager {

    @RequiresApi(Build.VERSION_CODES.P)
    fun encodeImageUriListToBase64(uriList:List<Uri>, context : Context):List<String>
    {
        var stringList = mutableListOf<String>()
        for(uri in uriList){
            stringList.add(this.encodeImageUriToBase64String(uri, context))
        }
        return stringList
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun encodeImageUriToBase64String(uri:Uri, context:Context):String
    {
        val source = ImageDecoder.createSource(context.contentResolver, uri)
        var bitmap = ImageDecoder.decodeBitmap(source)
        var stream = ByteArrayOutputStream();
        var compressed = bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream)
        var bytes = stream.toByteArray()
        var base64Image = Base64.getEncoder().encodeToString(bytes)
        return base64Image;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decodeBase64ListToBitmap(base64List:List<String>):List<ImageBitmap>{
        var bitmapList = mutableListOf<ImageBitmap>()

        for(string in base64List){
            bitmapList.add(this.decodeBase64ToImageBitmap(string))
        }

        return bitmapList;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decodeBase64ToImageBitmap(string:String): ImageBitmap
    {
        val imageData = Base64.getDecoder().decode(string)
        val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
        return bitmap.asImageBitmap()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDefaultProfilePictureAsBase64String():String{
        val url = URL("https://cataas.com/cat/cute")
        val inputStream = url.openStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)

        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        val base64 = Base64.getEncoder().encodeToString(byteArray)
        return base64;
    }
}