package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dirvingpatner.databinding.ActivitySigninBinding

class Signin : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        // Make the status bar transparent and adjust the status bar icon colors
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
//        }

        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, Verification::class.java)
            startActivity(intent)
        }

//        val button = findViewById<View>(R.id.nextBtn)
//
//        button.setOnClickListener {
//            val intent = Intent(this, Verification::class.java)
//            startActivity(intent)
//        }

    }
}