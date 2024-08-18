package com.example.firstcompose.twittyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstcompose.R
import com.example.firstcompose.twittyapp.api.ApiInterface
import com.example.firstcompose.twittyapp.repository.TweetsRepository
import com.example.firstcompose.twittyapp.ui.screens.CategoryScreen
import com.example.firstcompose.twittyapp.ui.screens.DetailsScreen
import com.example.firstcompose.twittyapp.ui.screens.practice.One
import com.example.firstcompose.twittyapp.viewmodels.CategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TwittyMainActivity : ComponentActivity() {

//    @Inject
//    lateinit var twittyApi: ApiInterface

//    @Inject
//    lateinit var repo: TweetsRepository

    //    private lateinit var categoryViewModel : CategoriesViewModel
    private val categoryViewModel: CategoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        categoryViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
//
//        categoryViewModel.temp.observe(this, Observer { categories ->
//            Log.e("repo", "observe categories: $categories")
//        })
//
//    val categoryViewModel: CategoriesViewModel = viewModel()
//    val categories = categoryViewModel.categories.collectAsState()

//        val todo = categoryViewModel.temp.collect{
//            Log.e("repo", "todo: $it")
//        }

//        val todo = categoryViewModel.temp.asLiveData()
//        todo.observe(this, Observer{
//            Log.e("repo", "todo: $it")
//        })


//        categoryViewModel.getCategories()

//        val categories = categoryViewModel.categories.asLiveData()
//        categories.observe(this, Observer{
//            Log.e("repo", "categories: $it")
//        })
//
//        lifecycleScope.launch {
//            categoryViewModel.categories.collect{
//                Log.e("repo", "lifecycle: $it")
//            }
//        }

//        callApi()
        setContent {
//            CategoryScreen()

//            DetailsScreen()

            App()


//            practice
//            One()
        }
    }


//    private fun callApi() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val job = CoroutineScope(Dispatchers.IO).launch {
//                val response = twittyApi.getTodo()
////            Log.e("TWITTY", "response $response")
//
////            val response = repo.getTodo("abcd")
//                Log.e("repo", "main response ${response}")
//            }
//            job.join()
//        }
//    }

}


@Composable
private fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route = "category"){
            CategoryScreen(navController)
        }

        composable(route = "detail/{category}", arguments = listOf(
            navArgument("category"){
                type = NavType.StringType
            }
        )){
            DetailsScreen()
        }
    }
}

@Preview
@Composable
fun CategoryItem2(title: String = "apple") {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Text(
            text = title,
            modifier = Modifier
                .background(Color.Red)
        )
    }
}