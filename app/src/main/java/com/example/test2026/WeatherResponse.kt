package com.example.test2026
data class WeatherResponse(
    val code: String,
    val now:Now
)
data class Now(
    val temp: String,
    val text: String
)
//和风天气的json转为kotlin的class