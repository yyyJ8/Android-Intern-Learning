package com.example.test2026

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class UserCenterActivity : AppCompatActivity(){
    companion object{
        const val KEY_USERNAME="username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
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