package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.run4me.R

class RegisterationActivity : AppCompatActivity() {
    lateinit var bt_next:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)
        bt_next=findViewById(R.id.bt_next)
        bt_next.setOnClickListener {
            var gotoregstatus=Intent(this,RegistrationStatusActivity::class.java)
            startActivity(gotoregstatus)

        }
    }
}