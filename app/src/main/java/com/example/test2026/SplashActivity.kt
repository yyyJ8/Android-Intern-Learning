package com.example.test2026

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.util.Log
class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "SplashActivity onStart") // 生命周期日志
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "SplashActivity onResume") // 生命周期日志
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "SplashActivity onPause") // 生命周期日志
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "SplashActivity onStop") // 生命周期日志
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "SplashActivity onDestroy") // 生命周期日志
    }
}