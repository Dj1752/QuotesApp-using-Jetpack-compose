package com.pratice.quotesappusingjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.pratice.quotesappusingjetpackcompose.model.Quotes
import java.nio.charset.Charset

object Datamanager {
     var data  = emptyArray<Quotes>()
     var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson= Gson()
        data = gson.fromJson(json,Array<Quotes>::class.java)
        isDataLoaded.value=true
    }
}