package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.dirvingpatner.databinding.ActivityDrivingLicenceUploadBinding

class DrivingLicenceUpload : AppCompatActivity() {

    // Declare the binding object for view binding
    private lateinit var binding: ActivityDrivingLicenceUploadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object by inflating the layout
        binding = ActivityDrivingLicenceUploadBinding.inflate(layoutInflater)


        // Set the root view to the binding's root (the layout's root view)
        setContentView(binding.root)

        // Customize the status bar appearance (color and text)
        changeColorStatusBar()

        // Set up the back button on the toolbar to go to the previous screen
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed() // Go back to the previous activity
        }

        // Set up the "Continue" button click listener
        binding.continueBtn.setOnClickListener{

            // Save the status of the Driving License section as complete in SharedPreferences
            val sharedPref = getSharedPreferences("DriverDocuments", MODE_PRIVATE).edit()
            sharedPref.putBoolean("isDrivingLicenseComplete", true)
            sharedPref.apply() // Apply the changes

            // Start the AdharCardUpload activity when the "Continue" button is clicked
            val intent = Intent(this, AdharCardUpload::class.java)
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