package com.example.dirvingpatner

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_verification)

        // Make the status bar transparent and adjust the status bar icon colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        }

        // Set the edge-to-edge behavior for the activity
        enableEdgeToEdge()

        val verifyButton = findViewById<View>(R.id.otpVerifyBtn)

        verifyButton.setOnClickListener {
            val intent = Intent(this, PatnerOption::class.java)
            startActivity(intent)
        }

    }
}