package com.example.firstcompose.twittyapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TweetCategories (
    @SerializedName("categories")
    val tweetCategories: List<String>?
):Serializable