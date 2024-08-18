package com.example.firstcompose.twittyapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//data class TweetsResponse (
//
//    @SerializedName("android")
//    val tweetList: List<Tweet>
//):Serializable


data class ExampleJson2KtKotlin (

    @SerializedName("_id"        ) var Id         : String?           = null,
    @SerializedName("categories" ) var categories : ArrayList<String> = arrayListOf()

)

data class TweetsResponse (
    @SerializedName("list")
    val tweetList: List<Tweet>
)

//data class TweetResponse (
//    @SerializedName("android")
//    val tweetList: List<Tweet2>
//)


//data class TweetsResponse (
//    val android: List<Tweet>
//)
//
//data class Tweet (
//    val id: Int,
//    val text: String,
//    val username: String,
//    val createdAt: String
//)

data class CategoryResponse(
    val categories: List<Categories>
):Serializable

data class Categories(
    @SerializedName("categories")
    val data: List<String>
)


data class Todo(
    val title: String?,
    val id: Int?
)