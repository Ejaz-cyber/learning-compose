package com.example.firstcompose.twittyapp.api

import com.example.firstcompose.twittyapp.models.CategoryResponse
import com.example.firstcompose.twittyapp.models.ExampleJson2KtKotlin
import com.example.firstcompose.twittyapp.models.Todo
import com.example.firstcompose.twittyapp.models.TweetsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("tweets-{type}")
    suspend fun getTweets(@Path("type") type: String): Response<List<TweetsResponse>>

    @GET("tweet-categories")
    suspend fun getCategories(): Response<List<ExampleJson2KtKotlin>>

    @GET("todos/1")
    suspend fun getTodo(): Response<Todo>
}