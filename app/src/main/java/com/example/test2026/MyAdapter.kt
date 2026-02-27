package com.example.test2026
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//Adapter 数据到界面的显示
//ViewHolder 缓存已经创建过的item 视图的重复使用
class MyAdapter(private val dataList: List<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val tvItem: TextView=itemView.findViewById(R.id.tv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_text,parent,false)
        //.inflate 将.xml解析成view对象
        return ViewHolder(view)
    }
    //在第一次要显示这个item的时候 根据xml文件转为view，包成ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text=dataList[position]
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "点击了第${position + 1}项：${dataList[position]}", Toast.LENGTH_SHORT).show()
        }
    }
    //拿到创建好的ViewHolder将数据填入 设置点击事件

    override fun getItemCount(): Int { //获取列表数据总数
        return dataList.size
    }
}