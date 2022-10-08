package com.octagonafrica.africa.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.octagonafrica.africa.R

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        //Go to OTPVerification page
        val buttonLogin:Button = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, OTPVerificationActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Go to Signup page
        val goToSignup:LinearLayout = findViewById(R.id.linearLayout6)
        goToSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}