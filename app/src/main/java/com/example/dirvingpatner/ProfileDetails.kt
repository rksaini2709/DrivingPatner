package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dirvingpatner.databinding.ActivityProfileDetailsBinding

class ProfileDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, DriverDocuments::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.cancelBtn.setOnClickListener {
            finish()
        }

//        val saveBtn = findViewById<Button>(R.id.save_btn)
//        saveBtn.setOnClickListener {
//            val intent = Intent(this, DriverDocuments::class.java)
//            startActivity(intent)
//        }

    }
}