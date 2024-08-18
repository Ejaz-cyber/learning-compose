package com.example.firstcompose.twittyapp.repository

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import com.example.firstcompose.twittyapp.api.ApiInterface
import com.example.firstcompose.twittyapp.models.ExampleJson2KtKotlin
import com.example.firstcompose.twittyapp.models.Todo
import com.example.firstcompose.twittyapp.models.Tweet
import com.example.firstcompose.twittyapp.models.TweetsResponse
import com.example.firstcompose.twittyapp.stateListeners.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.time.delay
import java.time.Duration
import java.util.logging.Handler
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val api: ApiInterface) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

//    val temp: MutableLiveData<List<ExampleJson2KtKotlin>?> = MutableLiveData(emptyList())


    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets


    private val _todo = MutableStateFlow<Todo?>(null)
    val todo: StateFlow<Todo?>
        get() = _todo





    suspend fun getTweets(type: String){
        Log.e("repo", "getTweets called")
        val response = api.getTweets(type)
        if(response.isSuccessful){
            Log.e("repo", "getTweets data ${response.body()}")
            _tweets.emit(response.body()?.get(0)?.tweetList!!)
            Log.e("repo", "getTweets data $tweets")
        }else{
            Log.e("repo", "getTweets failed: ${response}")
        }
    }

    suspend fun getCategories(){
        Log.e("repo", "getCategories called")
        val response = api.getCategories()
        if(response.isSuccessful){
            Log.e("repo", "getCategories data $response")
            _categories.emit(response.body()?.get(0)?.categories!!)
        }else{
            Log.e("repo", "getCategories failed: ${response}")
        }
    }

    suspend fun getTodo() {
        Log.e("repo", "getTodo called--")
        try {
            val response = api.getTodo()
            if (response != null) {
                Log.e("repo", "getTodo response: $response")
                _todo.value = response.body()
            } else {
                Log.e("repo", "getTodo response is null")
            }
        } catch (e: Exception) {
            Log.e("repo", "Error: $e")
        }
    }


}