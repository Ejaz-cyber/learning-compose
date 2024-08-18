package com.example.firstcompose.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.quotesapp.models.Quote

@Composable
fun QuoteListScreen(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(text = "Quotes App Jetpack Compose",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f)
                .padding(10.dp),
            fontSize = 23.sp)

        QuoteList(quotes = quotes, onClick)

    }
}