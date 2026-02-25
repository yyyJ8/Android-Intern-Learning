package com.example.test2026

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class UserCenterActivity : AppCompatActivity(){
    companion object{
        const val KEY_USERNAME="username"
    }
    private lateinit var ivAvatar: ImageView
    private var isAvatar1 = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
        ivAvatar = findViewById<ImageView>(R.id.iv_avatar)
        ivAvatar.setOnClickListener{
            if (isAvatar1){
                ivAvatar.setImageResource(R.drawable.avatar2)
                isAvatar1 = false
            }else{
                ivAvatar.setImageResource(R.drawable.avatar1)
                isAvatar1 = true
            }
        }
        val username= intent.getStringExtra(KEY_USERNAME)?:"未知用户"
        val tvUsername=findViewById<TextView>(R.id.tv_username)
        tvUsername.text="用户名：$username"
        val btnLogout=findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}