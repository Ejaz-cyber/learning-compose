package com.example.firstcompose.twittyapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.twittyapp.api.ApiInterface
import com.example.firstcompose.twittyapp.models.ExampleJson2KtKotlin
import com.example.firstcompose.twittyapp.models.Todo
import com.example.firstcompose.twittyapp.models.Tweet
import com.example.firstcompose.twittyapp.models.TweetsResponse
import com.example.firstcompose.twittyapp.repository.TweetsRepository
import com.example.firstcompose.twittyapp.stateListeners.ResponseState
import com.example.firstcompose.twittyapp.stateListeners.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: TweetsRepository) :
    ViewModel() {

    /*    val categories: StateFlow<List<String>>
        get() = repository.categories
    */

    private var categories: UIState<List<String>> by mutableStateOf(UIState(isLoading = false))
    val mCategories: UIState<List<String>> get() = categories

    private fun getCategories() {
        viewModelScope.launch {
            Log.i("repo", "calling get categories")
            repository.getCategories().collect {
                categories = when (it) {
                    is ResponseState.Loading -> {
                        UIState(isLoading = true)
                    }

                    is ResponseState.Failure -> {
                        UIState(isFailure = it.error)
                    }

                    is ResponseState.Success -> {
                        UIState(data = it.data)
                    }
                }
            }
        }
    }

    init {
        getCategories()
    }
}