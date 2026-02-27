package com.example.test2026
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val newsTitle=intent.getStringExtra("title")?:"无标题"
        val tvDetailTitle = findViewById<TextView>(R.id.tv_detail_title)
        tvDetailTitle.text = newsTitle

        // 新增返回按钮逻辑
        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish() // 关闭详情页，返回列表页
        }
    }

}