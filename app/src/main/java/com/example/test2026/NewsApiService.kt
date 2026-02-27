package com.example.test2026

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService{
    @GET("v2/top-headlines")
    fun getNews(
        @Query("country")country: String="cn",
        @Query("key")key: String
    ): Call<NewsResponse>
}