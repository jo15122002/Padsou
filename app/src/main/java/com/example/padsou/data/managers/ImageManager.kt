package com.example.padsou.data.managers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
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
    fun decodeBase64ListToBitmap(base64List:List<String>):List<Bitmap>{
        var bitmapList = mutableListOf<Bitmap>()

        for(string in base64List){
            bitmapList.add(this.decodeBase64ToBitmap(string))
        }

        return bitmapList;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decodeBase64ToBitmap(string:String):Bitmap
    {
        val imageData = Base64.getDecoder().decode(string)
        val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
        return bitmap
    }
}