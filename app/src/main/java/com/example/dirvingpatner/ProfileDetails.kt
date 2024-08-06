package com.example.dirvingpatner

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile_details)

        val saveBtn = findViewById<Button>(R.id.save_btn)
        saveBtn.setOnClickListener {
            val intent = Intent(this, DriverDocuments::class.java)
            startActivity(intent)
        }
    }
}