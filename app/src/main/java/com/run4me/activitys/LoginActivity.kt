package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import com.run4me.R

class LoginActivity : AppCompatActivity() {
    lateinit var btn_continue: AppCompatButton
    lateinit var et_mobilenumber: AppCompatEditText
    lateinit var imgbt_crossmobilelogin: AppCompatImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_continue = findViewById(R.id.btn_continue)
        imgbt_crossmobilelogin = findViewById(R.id.imgbt_crossmobilelogin)
        et_mobilenumber = findViewById(R.id.et_mobilenumber)
        btn_continue.setOnClickListener {
            startActivity(Intent(this, OTPActivity::class.java))
        }
        imgbt_crossmobilelogin.setOnClickListener {
            et_mobilenumber.setText("")
        }
    }
}