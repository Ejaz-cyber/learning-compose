package com.example.firstcompose.twittyapp.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.twittyapp.models.Tweet
import com.example.firstcompose.twittyapp.models.TweetsResponse
import com.example.firstcompose.twittyapp.repository.TweetsRepository
import com.example.firstcompose.twittyapp.stateListeners.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TweetsRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val tweetList: StateFlow<List<Tweet>>
        get() = repository.tweets


    init {
//        Log.e("repo", "details vm get tweet called")
        val category = savedStateHandle.get<String>("category") ?: "android"
        getTweets(category)
    }

    private fun getTweets(category: String) {
        Log.e("repo", "details vm callign-- $category")
        viewModelScope.launch(Dispatchers.IO){
            try{
//                Log.i("repo", "calling get tweets api")
                repository.getTweets(category)
            }catch (e: Exception){
                Log.e("repo", "getTweets error: ${e.localizedMessage}")
            }
        }
    }
}