package com.example.firstcompose.twittyapp.stateListeners

sealed interface ResponseState<out T> {

    data class Success<T>(val data: T): ResponseState<T>

    data class Failure(val error: String?): ResponseState<Nothing>

    object Loading: ResponseState<Nothing>
}