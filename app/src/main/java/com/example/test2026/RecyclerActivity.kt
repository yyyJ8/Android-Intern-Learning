package com.example.test2026
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
class RecyclerActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val dataList=listOf("新闻1", "新闻2", "新闻3", "新闻4", "新闻5", "新闻6",
                        "新闻7", "新闻8", "新闻9", "新闻10", "新闻11", "新闻12")
//        val newsList = listOf(
//            NewsItem("安卓开发入门教程", "2026.3.20", R.drawable.news1),
//            NewsItem("RecyclerView图文列表实现", "2026.3.21", R.drawable.news2),
//            NewsItem("Intent传值与跳转", "2026.3.22", R.drawable.news3),
//            NewsItem("Activity生命周期详解", "2026.3.23", R.drawable.news4),
//            NewsItem("Service后台服务入门", "2026.3.24", R.drawable.news5),
//            NewsItem("BroadcastReceiver广播接收", "2026.3.25", R.drawable.news6),
//            NewsItem("自定义Adapter核心要点", "2026.3.26", R.drawable.news7),
//            NewsItem("ViewHolder缓存机制", "2026.3.27", R.drawable.news8),
//            NewsItem("图文列表点击跳转详情页", "2026.3.28", R.drawable.news3)
//        )

        rvList.layoutManager = LinearLayoutManager(this) //垂直列表
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvList.addItemDecoration(divider)
//        rvList.layoutManager= GridLayoutManager(this,2)
//        rvList.adapter = MyAdapter(dataList)//绑定自定义Adapter
//        rvList.adapter = NewsAdapter(newsList)
    }
}