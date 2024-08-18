package com.example.firstcompose.twittyapp.stateListeners

sealed interface UIState<out T> {

    data class Success<T>(val data: T): UIState<T>

    data class Failure(val error: String?): UIState<Nothing>

    object Loading: UIState<Nothing>
}