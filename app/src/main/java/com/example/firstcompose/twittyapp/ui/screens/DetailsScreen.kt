package com.example.firstcompose.twittyapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstcompose.R
import com.example.firstcompose.twittyapp.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {

//    val tweetList = detailsViewModel.tweetList.collectAsState()
//    Log.e("repo", "details ${tweetList.value}")

//    val tweetList = remember {
//        mutableStateListOf<Tweet>()
//    }
//    var error = remember {
//        mutableStateOf<String?>(null)
//    }
//
//    CoroutineScope(Dispatchers.IO).launch{
//        detailsViewModel.getTweets2().collect{
//            when(it){
//                is UIState.Loading -> {
//                    Log.e("ui", "loading")
//                }
//                is UIState.Failure -> {
//                    Log.e("ui", "error")
//                    error.value = it.error
//                }
//                is UIState.Success -> {
//                    Log.e("ui", "data ${it.data}")
//                    tweetList.addAll(it.data)
//                }
//            }
//        }
//    }



    if(!detailsViewModel.mList.isFailure.isNullOrEmpty()){
        ShowError(error = detailsViewModel.mList.isFailure.toString())
    }else if(detailsViewModel.mList.isLoading){
        ShowLoading()
    }else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),
            content = {
                items(items = detailsViewModel.mList.data!!, key = {
                    it.id.toString()
                }){
                    Item(tweet = it.text.toString(), user = it.username.toString())
                }

            }
        )
    }

}

@Composable
fun ShowError(error: String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = error)
    }
}

@Composable
fun ShowLoading(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Loading...")
    }
}


@Composable
fun Item(tweet: String, user: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
                .padding(12.dp)

        )
        Column(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                text = tweet,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Light,
                )
            )
            Text(
                text = user,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                ),
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
    }


}