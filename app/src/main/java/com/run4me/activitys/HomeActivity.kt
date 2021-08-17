package com.run4me.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.run4me.R

class HomeActivity : AppCompatActivity() {
    lateinit var img_home_profile: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        img_home_profile=findViewById(R.id.img_home_profile)
        img_home_profile.setOnClickListener {
            var gotoProfilePage=Intent(this,ProfileActivity::class.java)
            startActivity(gotoProfilePage)

        }
    }
}