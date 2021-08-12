package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.run4me.R

class PreLoginActivity : AppCompatActivity() {
    lateinit var termsTv: TextView
    lateinit var signwithmobilenumber: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)
        termsTv = findViewById(R.id.txt_terms)
        signwithmobilenumber = findViewById(R.id.signwithmobilenumber)
        signwithmobilenumber.setOnClickListener { startActivity(Intent(this,LoginActivity::class.java)) }
        SpannableStringWithColor(
            termsTv,
            29,
            49,
            "By signing in,you accept our Terms and conditions"
        )
    }

  private  fun SpannableStringWithColor(view: TextView, start: Int, end: Int, s: String) {
        val wordtoSpan: Spannable =
            SpannableString(s)
        wordtoSpan.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    view.context,
                    R.color.green
                )
            ),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        view.text = wordtoSpan
    }
}