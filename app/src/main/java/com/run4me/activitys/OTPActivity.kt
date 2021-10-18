package com.run4me.activitys

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.run4me.R

class OTPActivity : AppCompatActivity() {
    lateinit var imgbt_cross: ImageButton
    lateinit var otp1: AppCompatEditText
    lateinit var otp2: AppCompatEditText
    lateinit var otp3: AppCompatEditText
    lateinit var otp4: AppCompatEditText
    lateinit var txt_changenumber: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o_t_p)
        otp1 = findViewById(R.id.et_otp1)
        otp2 = findViewById(R.id.et_otp2)
        otp3 = findViewById(R.id.et_otp3)
        otp4 = findViewById(R.id.et_otp4)
        txt_changenumber = findViewById(R.id.txt_changenumber)
        imgbt_cross = findViewById(R.id.imgbt_cross)
        txt_changenumber.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        imgbt_cross.setOnClickListener {
            otp1.setText("");
            otp2.setText("");
            otp3.setText("");
            otp4.setText("");
        }

        //GenericTextWatcher here works only for moving to next EditText when a number is entered
//first parameter is the current EditText and second parameter is next EditText
        otp1.addTextChangedListener(GenericTextWatcher(otp1, otp2))
        otp2.addTextChangedListener(GenericTextWatcher(otp2, otp3))
        otp3.addTextChangedListener(GenericTextWatcher(otp3, otp4))
        otp4.addTextChangedListener(GenericTextWatcher(otp4, null))

//GenericKeyEvent here works for deleting the element and to switch back to previous EditText
//first parameter is the current EditText and second parameter is previous EditText
        otp1.setOnKeyListener(GenericKeyEvent(otp1, null))
        otp2.setOnKeyListener(GenericKeyEvent(otp2, otp1))
        otp3.setOnKeyListener(GenericKeyEvent(otp3, otp2))
        otp4.setOnKeyListener(GenericKeyEvent(otp4, otp3))
    }

    class GenericKeyEvent internal constructor(
        private val currentView: AppCompatEditText,
        private val previousView: AppCompatEditText?
    ) : View.OnKeyListener {
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.et_otp1 && currentView.text?.isEmpty() ?:false) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }


    }

    class GenericTextWatcher internal constructor(
        private val currentView: View,
        private val nextView: View?
    ) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.et_otp1 -> if (text.length == 1) nextView?.requestFocus()
                R.id.et_otp2 -> if (text.length == 1) nextView?.requestFocus()
                R.id.et_otp3 -> if (text.length == 1) nextView?.requestFocus()
                R.id.et_otp4 -> if (text.length == 1) nextView?.requestFocus()
                //You can use EditText4 same as above to hide the keyboard
            }
        }

        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

    }
}