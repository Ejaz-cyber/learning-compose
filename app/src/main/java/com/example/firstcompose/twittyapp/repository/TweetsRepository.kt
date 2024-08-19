package com.example.firstcompose.twittyapp.repository

import android.util.Log
import com.example.firstcompose.twittyapp.api.ApiInterface
import com.example.firstcompose.twittyapp.models.Todo
import com.example.firstcompose.twittyapp.models.Tweet
import com.example.firstcompose.twittyapp.stateListeners.ResponseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.time.delay
import java.time.Duration
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val api: ApiInterface) {

    /*private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories*/

//    val temp: MutableLiveData<List<ExampleJson2KtKotlin>?> = MutableLiveData(emptyList())


    /*    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
        val tweets: StateFlow<List<Tweet>>
        get() = _tweets*/


    /*
        private val _todo = MutableStateFlow<Todo?>(null)
        val todo: StateFlow<Todo?>
            get() = _todo
    */


    fun getTweets(type: String) = flow{
        emit(ResponseState.Loading)
        Log.e("repo", "getTweets called")
        delay(Duration.ofSeconds(3))
        val data = api.getTweets(type)
        Log.e("repo", "getTweets $data")
        if(data.isSuccessful && data.body()?.isEmpty() == false){
            emit(ResponseState.Success(data.body()))
            return@flow
        }

        if(data.body()?.isEmpty() == true){
            emit(ResponseState.Failure("data not available"))
        }
    }.catch {
        emit(ResponseState.Failure(it.message.toString()))
    }

    fun getCategories() = flow{
        Log.e("repo", "getCategories called")

        emit(ResponseState.Loading)
        delay(Duration.ofSeconds(5))

        val data = api.getCategories()
        if(data.isSuccessful){
            if(data.body()?.isEmpty() == true){
                emit(ResponseState.Failure("no data found"))
                return@flow
            }

            Log.e("repo", "getCategories $data")
            emit(ResponseState.Success(data.body()?.get(0)?.categories!!))
        }
    }.catch {
        Log.e("repo", "getCategories failed")
        emit(ResponseState.Failure("failed to get data"))
    }

    /*suspend fun getCategories(){
        Log.e("repo", "getCategories called")
        val response = api.getCategories()
        if(response.isSuccessful){
            Log.e("repo", "getCategories data $response")
            _categories.emit(response.body()?.get(0)?.categories!!)
        }else{
            Log.e("repo", "getCategories failed: ${response}")
        }
    }*/

    /*suspend fun getTodo() {
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
    }*/


}