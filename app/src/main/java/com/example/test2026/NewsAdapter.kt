package com.example.test2026
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test2026.MyAdapter.ViewHolder

//data class NewsItem(val title: String, val time: String, val imageRes: Int)
class NewsAdapter(private val newsList: List<Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivCover=itemView.findViewById<ImageView>(R.id.iv_cover)
        val tvTitle=itemView.findViewById<TextView>(R.id.tv_title)
        val tvTime=itemView.findViewById<TextView>(R.id.tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = newsList[position]
//        holder.tvTitle.text=news.title
//        holder.tvTime.text=news.time
//        holder.ivCover.setImageResource(news.imageRes)
        holder.tvTitle.text=article.title
        val simpleTime = article.publishedAt.split("T")[0]


        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,NewsDetailActivity::class.java)
            intent.putExtra("title",article.title)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}