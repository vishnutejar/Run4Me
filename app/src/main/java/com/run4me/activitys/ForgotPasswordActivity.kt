package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.run4me.R

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var txt_enterphnum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        txt_enterphnum = findViewById(R.id.txt_enterphnum)
        txt_enterphnum.setOnClickListener {
            val intent = Intent(this, ResetYourPasswordActivity::class.java)
            startActivity(intent)
        }
        SpannableStringWithColor(
            txt_enterphnum,
            25,
            45,
            "Enter your phone number to reset your password."
        )

    }

    private fun SpannableStringWithColor(view: TextView, start: Int, end: Int, s: String) {
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