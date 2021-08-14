package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.run4me.R

class RegistrationStatusActivity : AppCompatActivity() {
    lateinit var bottmtitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_status)
        bottmtitle=findViewById(R.id.bottmtitle)
        bottmtitle.setOnClickListener {
            val gotoHomeScreen=Intent(this,HomeActivity::class.java)
            startActivity(gotoHomeScreen)
        }
    }
}