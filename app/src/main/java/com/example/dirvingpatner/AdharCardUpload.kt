package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.dirvingpatner.databinding.ActivityAdharCardUploadBinding

class AdharCardUpload : AppCompatActivity() {

    private lateinit var binding : ActivityAdharCardUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdharCardUploadBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Customize the status bar appearance (color and text)
        changeColorStatusBar()

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        // Set up the "Continue" button click listener
        binding.continueBtn.setOnClickListener{

            // Save the status of the Driving License section as complete in SharedPreferences
            val sharedPref = getSharedPreferences("DriverDocuments", MODE_PRIVATE).edit()
            sharedPref.putBoolean("isAdharCardComplete", true)
            sharedPref.apply() // Apply the changes

            // Start the PanCardUpload activity when the "Continue" button is clicked
            val intent = Intent(this, PanCardUpload::class.java)
            startActivity(intent)
        }
    }
    // Function to customize the status bar appearance
    private fun changeColorStatusBar() {
        val window: Window = this.window


        // Enable the system to draw the status bar with a custom color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)


        // Set the status bar color to DarkBlue
        window.statusBarColor = ContextCompat.getColor(this, R.color.DarkBlue)


        // Set the status bar text color to light or dark
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false // Set to true for light text, false for dark text
        }
    }

    // Override the onBackPressed() method to customize back navigation behavior
    override fun onBackPressed() {
        super.onBackPressed()


        // Explicitly navigate back to the DriverDocuments activity
        val intent = Intent(this, DriverDocuments::class.java)


        // Clear the current activity and bring the DriverDocuments activity to the front
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish() // Finish the current activity
    }
}