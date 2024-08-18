package com.example.firstcompose.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.quotesapp.models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit){
    Card (
        modifier = Modifier
            .clickable {
                onClick(quote)
            }
            .padding(10.dp)
            .background(Color.White)
            .fillMaxWidth(1f)
//            .border(shape = RectangleShape, border = BorderStroke(width = 2.dp, Color.Red))
        ,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row (modifier = Modifier
            .background(Color.White)
            .padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.DarkGray),
                contentDescription = "person",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Column (modifier = Modifier.weight(1f)){
                Text(text = quote.quote,
                    style = TextStyle(fontSize = 19.sp)
                )
                Box (modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(vertical = 6.dp)
                    .height(1.dp)
                    .background(Color(0xFFEEEEEE))
                    )
                Text(text = quote.author,
                    style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
