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
    lateinit var fb_signwithmobilenumber: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)
        termsTv = findViewById(R.id.txt_terms)
        signwithmobilenumber = findViewById(R.id.signwithmobilenumber)
        fb_signwithmobilenumber = findViewById(R.id.fb_signwithmobilenumber)
        signwithmobilenumber.setOnClickListener { startActivity(Intent(this,LoginActivity::class.java)) }
        fb_signwithmobilenumber.setOnClickListener { startActivity(Intent(this,RegisterationActivity::class.java)) }
        SpannableStringWithColor(
            termsTv,
            29,
            49,
            "By signing in,you accept our Terms and conditions"
        )

        termsTv.setOnClickListener {
            val gotoTermspage=Intent(this,TermsAndConditionActivity::class.java);
            startActivity(gotoTermspage)
        }
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