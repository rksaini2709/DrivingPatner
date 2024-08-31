package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.dirvingpatner.databinding.ActivityVehiclePermitBinding

class VehiclePermit : AppCompatActivity() {

    private lateinit var binding: ActivityVehiclePermitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVehiclePermitBinding.inflate(layoutInflater)

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
            sharedPref.putBoolean("isVehiclePermitComplete", true)
            sharedPref.apply() // Apply the changes

            // Start the PanCardUpload activity when the "Continue" button is clicked
            val intent = Intent(this, DriverDocuments::class.java)
            startActivity(intent)
        }
    }

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

    override fun onBackPressed() {
        super.onBackPressed()
        // Explicitly navigate to a specific activity

        val intent = Intent(this, DriverDocuments::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }
}