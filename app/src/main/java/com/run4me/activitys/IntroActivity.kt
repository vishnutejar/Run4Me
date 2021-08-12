package com.run4me.activitys

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.run4me.R
import com.run4me.adapters.ViewPagerAdapter


class IntroActivity : AppCompatActivity() {
    lateinit var btn_skip: Button
    lateinit var btn_next: Button
    private var dots = listOf<TextView>()
    private lateinit var viewPager2: ViewPager2
    var imagesList = listOf(
        R.drawable.introone,
        R.drawable.introtwo,
        R.drawable.introthree
    )
    var colorsActive = listOf(R.drawable.active_dot, R.drawable.active_dot, R.drawable.active_dot)
    var colorsInactive = listOf(
        R.drawable.inactive_dot,
        R.drawable.inactive_dot,
        R.drawable.inactive_dot
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        btn_next = findViewById(R.id.btn_next)
        btn_skip = findViewById(R.id.btn_skip)
        viewPager2 = findViewById(R.id.view_pager)

        val adapter = ViewPagerAdapter(imagesList)
        viewPager2.adapter = adapter

        btn_next.setOnClickListener(View.OnClickListener {
            val current = getItem(+1)
            if (current < imagesList.size)
                viewPager2.currentItem = current

        })
        btn_skip.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, PreLoginActivity::class.java))

        })
    }

    private fun getItem(i: Int): Int {
        return viewPager2.currentItem + i
    }

    fun addDots(current: Int) {
    }

}