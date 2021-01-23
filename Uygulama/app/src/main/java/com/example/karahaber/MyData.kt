package com.example.karahaber


import com.google.gson.annotations.SerializedName

data class MyData(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)