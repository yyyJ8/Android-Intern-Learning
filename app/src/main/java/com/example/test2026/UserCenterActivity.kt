package com.example.test2026

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import android.app.Activity
class UserCenterActivity : AppCompatActivity(){
    companion object{
        const val KEY_USERNAME="username"
    }
    private lateinit var ivAvatar: ImageView
    private var isAvatar1 = true

    private var originalUsername = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
        Log.d("Lifecycle", "UserCenterActivity onCreate")

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

        val username= intent.getStringExtra("username")?:"未知用户"
        val password=intent.getStringExtra("password")?:""
        val isLogin=intent.getBooleanExtra("isLogin",false)
        Log.d("IntentData", "收到用户名: $username, 密码: $password, 是否登录: $isLogin")

        val tvUsername=findViewById<TextView>(R.id.tv_username)
        tvUsername.text="用户名：$username"
        Toast.makeText(this, "$username 欢迎回来", Toast.LENGTH_SHORT).show()

        val btnLogout=findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val etNewNickname=findViewById<TextInputEditText>(R.id.et_new_nickname)
        originalUsername=intent.getStringExtra("username")?:"未知用户"
        val btnConfirmModify=findViewById<Button>(R.id.btn_confirm_modify)
        tvUsername.setOnClickListener{
            etNewNickname.visibility = TextView.VISIBLE  //将visibility 设为可见visible
            btnConfirmModify.visibility = Button.VISIBLE
            etNewNickname.setText(originalUsername)
            etNewNickname.requestFocus() //让输入框获得输入焦点，光标会出现在输入框里
            Toast.makeText(this, "请输入新昵称", Toast.LENGTH_SHORT).show()
        }
        btnConfirmModify.setOnClickListener {
            val newNickname = etNewNickname.text?.toString()?.trim() ?: originalUsername
            if (newNickname.isEmpty()) {
                Toast.makeText(this, "昵称不能为空！", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (newNickname == originalUsername) {
                Toast.makeText(this, "新昵称与原昵称一致！", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultIntent = Intent()
            resultIntent.putExtra("newNickname", newNickname)
            setResult(Activity.RESULT_OK, resultIntent)//设置当前 Activity 的返回结果 Activity.RESULT_OK是系统常量-1，表示操作成功

            etNewNickname.visibility = TextView.GONE
            btnConfirmModify.visibility = Button.GONE
            tvUsername.text = "用户名：$newNickname"
            originalUsername = newNickname
            Toast.makeText(this, "昵称修改成功！", Toast.LENGTH_SHORT).show()
            Log.d("ReturnData", "个人中心页返回新昵称：$newNickname")
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "UserCenterActivity onStart") // 生命周期日志
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "UserCenterActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "UserCenterActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "UserCenterActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "UserCenterActivity onDestroy")
    }
}

//Android四大组件： Activity（界面）、
//                Service（后台）、
//                BroadcastReceiver（广播）、
//                ContentProvider（数据共享）