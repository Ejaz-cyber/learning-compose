package com.example.firstcompose.twittyapp.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.firstcompose.twittyapp.viewmodels.CategoriesViewModel

@Composable
fun CategoryScreen(
    navController: NavController,
    categoryViewModel: CategoriesViewModel = hiltViewModel()
) {

    if (categoryViewModel.mCategories.isLoading) {
        ShowLoading()
    } else if (!categoryViewModel.mCategories.isFailure.isNullOrEmpty()) {
        ShowError(error = categoryViewModel.mCategories.isFailure.toString())
    } else {
        categoryViewModel.mCategories.data?.let { data ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(4.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(data) {
                    CategoryItem(it, navController)
                }
            }
        }
    }

//    categoryViewModel.mCategories.apply {
//        if(this.isLoading){
//            ShowLoading()
//        }
//
//        if(isFailure != null){
//            ShowError(error = isFailure)
//        }
//
//        if(!data.isNullOrEmpty()){
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                contentPadding = PaddingValues(4.dp),
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                items(data as List<String>) {
//                    CategoryItem(it, navController)
//                }
//            }
//        }
//    }
}

@Composable
fun CategoryItem(title: String, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray)
            .clickable {
                navController.navigate("detail/${title}")
            },
        contentAlignment = Alignment.BottomCenter,

        ) {
        Text(
            text = title,
            modifier = Modifier
                .background(Color.Red)
        )
    }
}