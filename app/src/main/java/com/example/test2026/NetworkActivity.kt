package com.example.test2026

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NetworkActivity : AppCompatActivity() {

    // 初始化 Retrofit 实例
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://devapi.qweather.com/") // 和风天气开发版基础地址，结尾必须带 /
        .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析 JSON
        .build()
    private val newsRetrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService = retrofit.create(ApiService::class.java)
    private val newsApiService = newsRetrofit.create(NewsApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        // 绑定按钮和文本控件
        val btnGetWeather = findViewById<Button>(R.id.btn_get_weather)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val btnGetNews = findViewById<Button>(R.id.btn_get_news)
        val rvNews = findViewById<RecyclerView>(R.id.rv_news)
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        btnGetWeather.setOnClickListener {
            loadWeather(tvResult)
        }
        btnGetNews.setOnClickListener {
            loadNews(rvNews)
        }
    }

    private fun loadWeather(tvResult: TextView) {
        // 和风天气 API Key
        val weatherKey = "8cf74867ceb94fb0a6e6628ee7140410"

        // 发起 GET 请求（查询北京天气）
        apiService.getWeather("101010100", weatherKey)
            .enqueue(object : Callback<WeatherResponse>//enqueue是Call<WeatherResponse>的方法，让后台发出请求，有结果之后在回调
            {
                // 请求成功回调
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>//一整个 HTTP 响应包
                ) {
                    if (response.isSuccessful) {
                        // 解析返回数据
                        val temp = response.body()?.now?.temp ?: "未知"
                        val text = response.body()?.now?.text ?: "未知"

                        tvResult.text = "北京温度：${temp}°C，天气：$text"

                        Log.d("Weather", "请求成功 → 温度：$temp°C，天气：$text")
                    } else {
                        // 响应成功但状态码非 200（如 Key 错误、城市不存在）
                        val errorCode = response.code()
                        Log.e("Weather", "响应失败：状态码 $errorCode")
                        Toast.makeText(
                            this@NetworkActivity,
                            "请求失败：状态码 $errorCode",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                // 请求失败回调
                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) { //Throwable 错误的集合
                    val errorMsg = t.message ?: "未知错误"
                    Log.e("Weather", "请求失败：$errorMsg")
                    Toast.makeText(
                        this@NetworkActivity,
                        "请求失败：$errorMsg",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
    private fun loadNews(rvNews: RecyclerView){
        val newsKey = "209db5fd4afb4c6abf86ce3ce4c51726"
        newsApiService.getNews("cn", newsKey)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ){
                    if (response.isSuccessful) {
                        val articles = response.body()?.articles ?: emptyList()
                        rvNews.adapter = NewsAdapter(articles)
                        Log.d("News", "获取${articles.size}条新闻，展示成功")
                        Toast.makeText(this@NetworkActivity, "获取${articles.size}条新闻", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        val errorCode = response.code()
                        Log.e("News", "响应失败：状态码$errorCode")
                        Toast.makeText(this@NetworkActivity, "Key错误/接口限制", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    val errorMsg = t.message ?: "未知错误"
                    Log.e("News", "请求失败：$errorMsg")
                    Toast.makeText(this@NetworkActivity, "请求失败：$errorMsg", Toast.LENGTH_LONG).show()
                }
            })

    }
}