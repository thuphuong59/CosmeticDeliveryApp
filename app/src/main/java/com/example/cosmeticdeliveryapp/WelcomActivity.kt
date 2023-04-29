package com.example.cosmeticdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class WelcomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)

        // delay picture
        Handler().postDelayed({
            startActivity(Intent(this,MainProductActivity::class.java))
        },1000)
    }
}