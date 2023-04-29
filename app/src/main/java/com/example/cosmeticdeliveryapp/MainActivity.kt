package com.example.cosmeticdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cosmeticdeliveryapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnEnter.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.txtsignin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.homee.setOnClickListener {
            startActivity(Intent(this, MainProductActivity::class.java))
        }

    }
}