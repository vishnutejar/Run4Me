package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.run4me.R

class LoginActivity : AppCompatActivity() {
    lateinit var btn_continue: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_continue=findViewById(R.id.btn_continue)
        btn_continue.setOnClickListener {
            startActivity(Intent(this,OTPActivity::class.java))
        }
    }
}