package com.example.test2026

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG= "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupClickListeners()
    }
    private fun setupClickListeners(){
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val username=findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.et_username).text.toString()
            val password=findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.et_password).text.toString()
            if(username.isEmpty()){
                Toast.makeText(this,"请输入用户名", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this,"成功登录！欢迎$username", Toast.LENGTH_SHORT).show()
            Log.d(TAG,"用户$username 成功登录")
        }
        findViewById<TextView>(R.id.tv_forget_pwd).setOnClickListener {
            Toast.makeText(this,"跳转到找回密码页面", Toast.LENGTH_SHORT).show()
            Log.d(TAG,"点击忘记密码")
        }
        findViewById<TextView>(R.id.tv_register).setOnClickListener {
            Toast.makeText(this, "跳转到注册页面", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "点击了立即注册")
        }
    }


}