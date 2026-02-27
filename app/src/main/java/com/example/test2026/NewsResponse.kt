package com.example.test2026

data class NewsResponse(val articles:List<Article>)
data class Article(
    val title: String,
    val publishedAt: String,
    val urlToImage: String?)

