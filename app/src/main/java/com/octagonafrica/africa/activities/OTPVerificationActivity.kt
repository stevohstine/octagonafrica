package com.octagonafrica.africa.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import com.octagonafrica.africa.R

class OTPVerificationActivity : AppCompatActivity() {
    lateinit var inputCode1: EditText
    lateinit var inputCode2:EditText
    lateinit var inputCode3:EditText
    lateinit var inputCode4:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverification)

        inputCode1 = findViewById(R.id.inputCode1)
        inputCode2 = findViewById(R.id.inputCode2)
        inputCode3 = findViewById(R.id.inputCode3)
        inputCode4 = findViewById(R.id.inputCode4)
        setUpPinInputs()
        showSoftKeyboard(inputCode1)

        val submitOTPButton: Button = findViewById(R.id.submitOTPButton)
        submitOTPButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setUpPinInputs(){
        inputCode1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()){
                    inputCode2.requestFocus()
                }

                if (p0.toString().trim().length == 1){
                    inputCode2.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        inputCode2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()){
                    inputCode3.requestFocus()
                }else{
                    inputCode1.requestFocus()
                }

                if (p0.toString().trim().length == 1){
                    inputCode3.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        inputCode3.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()){
                    inputCode4.requestFocus()
                }else{
                    inputCode2.requestFocus()
                }

                if (p0.toString().trim().length == 1){
                    inputCode4.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        inputCode4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()){
                    //verify pin
                    val code1:String = inputCode1.text.toString().trim()
                    val code2:String = inputCode2.text.toString().trim()
                    val code3:String = inputCode3.text.toString().trim()
                    val code4:String = inputCode4.text.toString().trim()
                    val otp = code1+code2+code3+code4


                }else{
                    inputCode3.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        inputCode2.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && inputCode2.text.toString().trim().isEmpty()) {
                inputCode1.requestFocus()
            }
            false
        }
        inputCode3.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && inputCode3.text.toString().trim().isEmpty()) {
                inputCode2.requestFocus()
            }
            false
        }
        inputCode4.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && inputCode4.text.toString().trim().isEmpty()) {
                inputCode3.requestFocus()
            }
            false
        }
    }
    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}
