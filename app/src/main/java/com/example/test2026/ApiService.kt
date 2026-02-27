package com.example.test2026

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService{
    @GET("v7/weather/now")
    fun getWeather(@Query("location") city: String,
                   @Query("key") key: String  //和风天气API Key
    ): Call<WeatherResponse> //网络请求的封装对象，当这个请求被执行后，会返回一个 WeatherResponse类型的数据
}