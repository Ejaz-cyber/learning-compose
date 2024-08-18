package com.example.firstcompose.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstcompose.quotesapp.models.Quote

@Composable
fun QuoteList(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    
    LazyColumn(content = {
        items(quotes){
            QuoteListItem(quote = it, onClick)
        }
    })
}