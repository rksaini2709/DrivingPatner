package com.example.dirvingpatner

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dirvingpatner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Delay the transition to SignInActivity by 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
            finish()
        }, 3000)

        changeTextColorStatusBar()
    }
    private fun changeTextColorStatusBar(){
        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.DarkBlue)


        // Set the status bar text color to light or dark
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false // Set to true for light text, false for dark text
        }
    }
}