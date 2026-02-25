package com.example.test2026

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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

    private val getResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result : ActivityResult->
        if (result.resultCode == Activity.RESULT_OK){
            val newNickname = result.data?.getStringExtra("newNickname") ?: "未修改"
            Toast.makeText(this,"新的昵称修改成功：$newNickname", Toast.LENGTH_SHORT).show()
            Log.d("ReturnData","登录页接受新的昵称：$newNickname")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("Lifecycle", "LoginActivity onCreate")
        initViews()
        setupClickListeners()
    }

    override fun onStart() { //可见
        super.onStart()
        Log.d("Lifecycle","LoginActivity onStart")
    }

    override fun onResume() { //聚焦 可交互
        super.onResume()
        Log.d("Lifecycle","LoginActivity onResume")
    }

    override fun onPause() { //失焦  另一个activity要来了
        super.onPause()
        Log.d("LifeActivity","LoginActivity onPause")
    }
    override fun onStop() { //不可见
        super.onStop()
        Log.d("Lifecycle","LoginActivity onStop")
    }

    override fun onDestroy() { //销毁
        super.onDestroy()
        Log.d("Lifecycle","LoginActivity onDestroy")
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
            val username = etUsername.text?.toString()?.trim()?:""
            val password = etPassword.text?.toString()?.trim()?:""

            if (username.isEmpty()) {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent= Intent(this, UserCenterActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("password",password)
            intent.putExtra("isLogin",true)

            getResult.launch(intent)
//            startActivity(intent)
//            finish()
//            intent.putExtra(UserCenterActivity.KEY_USERNAME, username)
//            startActivity(intent)
//            finish()
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