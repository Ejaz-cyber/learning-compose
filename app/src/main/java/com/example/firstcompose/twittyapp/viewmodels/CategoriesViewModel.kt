package com.example.firstcompose.twittyapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.twittyapp.api.ApiInterface
import com.example.firstcompose.twittyapp.models.ExampleJson2KtKotlin
import com.example.firstcompose.twittyapp.models.Todo
import com.example.firstcompose.twittyapp.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: TweetsRepository, private val api: ApiInterface): ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

//    val temp: MutableLiveData<Todo> = MutableLiveData()
    val temp: StateFlow<Todo?>
        get() = repository.todo

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                Log.i("repo", "calling api")
////                val response = api.getTodo()
//                repository.getTodo()
////                if (response.isSuccessful) {
////                    val data = response.body()
////                    temp.postValue(data)
////                    Log.e("repo", "Response: $data")
////                } else {
////                    Log.e("repo", "Error: ${response.code()} ${response.message()}")
////                }
//            } catch (e: Exception) {
//                Log.e("repo", "Error: $e")
//            }
//        }
//    }

    fun getCategories(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.i("repo", "calling get categories")
                repository.getCategories()
            } catch (e: Exception){
                Log.e("repo", "get categories Error: $e")
            }
        }
    }

    init{
        getCategories()
    }
}