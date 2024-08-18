package com.example.firstcompose.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.firstcompose.quotesapp.models.Quote
import com.google.gson.Gson

object DataManager {
    var quotes = emptyArray<Quote>()
    var isLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LIST)
    var currentQuote: Quote? = null

    fun loadData(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val quotesJson = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quotes = gson.fromJson(quotesJson, Array<Quote>::class.java)
        isLoaded.value = true
    }

    fun switchPage(quote: Quote?) {
        if(currentPage.value == Pages.LIST){
            currentQuote = quote
            currentPage.value = Pages.DETAILS
        }else{
            currentPage.value = Pages.LIST
        }
    }

    enum class Pages{
        LIST,
        DETAILS
    }
}