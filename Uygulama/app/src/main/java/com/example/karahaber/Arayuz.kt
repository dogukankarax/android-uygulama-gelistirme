package com.example.karahaber

import retrofit2.Call
import retrofit2.http.GET

interface Arayuz {
    @GET("/v2/everything?q=bitcoin&from=2020-12-23&sortBy=publishedAt&apiKey=904f2ee7ce764c78858a44efadd413d3")
    fun getData(): Call<List<Article>>
}