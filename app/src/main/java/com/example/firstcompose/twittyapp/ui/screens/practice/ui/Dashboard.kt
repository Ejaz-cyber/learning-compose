package com.example.firstcompose.twittyapp.ui.screens.practice.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.firstcompose.R

@Composable
@Preview()
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFBEBCBC), Color(0xFFFFFFFF)),
//                    colors = listOf( Color.Red, Color.Gray),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
    ) {
        Surface(
            shadowElevation = 22.dp,
            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF47545F), Color(0xFF9E9A9A)),
//                    colors = listOf( Color.Red, Color.Gray),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY,
                        ),
//                        shape =  RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                    )
                    .fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(vertical = 60.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
//                            .background(Color.Red)
                            .padding(horizontal = 32.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(text = "Hello", style = TextStyle(color = Color.White))
                            Text(
                                text = "Ejaz Mahmood",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 6.dp),
                                style = TextStyle(color = Color.White)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(75.dp) // increased size to accommodate the border
                                .background(
                                    Color.White,
                                    CircleShape
                                ) // white background with circular shape
                                .padding(3.dp) // add padding to create space for the border
                                .clip(CircleShape),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = "person image",
                                modifier = Modifier
//                            .padding(5.dp)
                                    .background(Color.Gray, CircleShape)
                                    .size(70.dp) // image size
                                    .clip(CircleShape) // clip the image to a circular shape
                            )


                        }
                    }
                }

            }


        }
        Card(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .offset(y = (-40).dp)
                .shadow(elevation = 10.dp, RectangleShape)
        ) {
            Box(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .background(Color.White, )
            ) {

            }
        }
    }
}