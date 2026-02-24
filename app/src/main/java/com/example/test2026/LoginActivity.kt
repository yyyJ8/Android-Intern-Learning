package com.example.test2026

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LoginActivity"
    }

    private lateinit var etUsername: TextInputEditText
//    延迟初始化的私有变量 先声明变量但不赋值
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var tvForgetPwd: TextView
    private lateinit var tvRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvForgetPwd = findViewById(R.id.tv_forget_pwd)
        tvRegister = findViewById(R.id.tv_register)
    }

    private fun setupClickListeners() {
        btnLogin.setOnClickListener {
            val username = etUsername.text?.toString()?:""
            val password = etUsername.text?.toString()?:""

            if (username.isEmpty()) {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent= Intent(this, UserCenterActivity::class.java)
            intent.putExtra(UserCenterActivity.KEY_USERNAME, username)
            startActivity(intent)
            finish()
//            Toast.makeText(this, "成功登录！欢迎$username", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "用户$username 成功登录，密码长度：${password.length}")
        }

        tvForgetPwd.setOnClickListener {
            Toast.makeText(this, "跳转到找回密码页面", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "用户点击忘记密码按钮")
        }

        tvRegister.setOnClickListener {
            Toast.makeText(this, "跳转到注册页面", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "用户点击立即注册按钮")
        }
    }
}