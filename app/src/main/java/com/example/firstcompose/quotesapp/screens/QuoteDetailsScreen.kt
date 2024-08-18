package com.example.firstcompose.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.quotesapp.DataManager
import com.example.firstcompose.quotesapp.models.Quote

@Composable
fun QuoteDetails(quote: Quote) {

    BackHandler {
        DataManager.switchPage(null)
    }

    Box (contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1F)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.Gray,
                        Color.White
                    )
                )
            )) {

        Card (
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            modifier = Modifier.padding(36.dp)
        ) {
            Column (verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 30.dp)
            ){
                Image(imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "quote icon",
                    modifier = Modifier.size(58.dp)
                )

                Text(text = quote.quote,
                    style = TextStyle(fontSize = 22.sp)
                )

                Spacer(modifier = Modifier
                    .height(1.dp)
                    .padding(0.dp, 10.dp)
                    .background(Color.Gray))

                Text(text = quote.author,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}