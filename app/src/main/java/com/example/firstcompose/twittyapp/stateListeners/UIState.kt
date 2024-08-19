package com.example.firstcompose.twittyapp.stateListeners

data class UIState<out T> (
    val isLoading: Boolean = false,
    val isFailure : String? = null,
    val data : T? = null
)