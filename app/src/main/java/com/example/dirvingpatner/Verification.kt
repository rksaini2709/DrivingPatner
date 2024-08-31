package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dirvingpatner.databinding.ActivityVerificationBinding

class Verification : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityVerificationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.otpVerifyBtn.setOnClickListener {
            val intent = Intent(this, PatnerOption::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

//        val verifyButton = findViewById<View>(R.id.otpVerifyBtn)
//
//        verifyButton.setOnClickListener {
//            val intent = Intent(this, PatnerOption::class.java)
//            startActivity(intent)
//        }
    }
}