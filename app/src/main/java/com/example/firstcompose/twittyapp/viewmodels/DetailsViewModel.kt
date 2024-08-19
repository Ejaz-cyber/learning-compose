package com.example.firstcompose.twittyapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.twittyapp.models.Tweet
import com.example.firstcompose.twittyapp.repository.TweetsRepository
import com.example.firstcompose.twittyapp.stateListeners.ResponseState
import com.example.firstcompose.twittyapp.stateListeners.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TweetsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
//    val tweetList: StateFlow<List<Tweet>>
//        get() = repository.tweets

    private var list: UIState<List<Tweet>> by mutableStateOf(UIState(isLoading = true))
    val mList: UIState<List<Tweet>> get() = list


    init {
        viewModelScope.launch {
            getTweets()
        }
    }

    private suspend fun getTweets() {
        val category = savedStateHandle.get<String>("category") ?: "android"
        Log.e("repo", "details vm callign-- $category")


        repository.getTweets(category).collect {
            list = when (it) {
                is ResponseState.Loading -> {
                    UIState(isLoading = true)
                }

                is ResponseState.Failure -> {
                    UIState(isFailure = it.error)
                }

                is ResponseState.Success -> {
                    UIState(data = it.data?.get(0)?.tweetList!!)
                }
            }
        }
    }

}
