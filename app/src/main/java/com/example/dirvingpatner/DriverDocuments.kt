package com.example.dirvingpatner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.dirvingpatner.databinding.ActivityDriverDocumentsBinding

class DriverDocuments : AppCompatActivity() {

    // Declare the binding object for view binding
    private lateinit var binding: ActivityDriverDocumentsBinding

    // Declare the SharedPreferences object to store and retrieve data
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object by inflating the layout
        binding = ActivityDriverDocumentsBinding.inflate(layoutInflater)

        // Set the root view to the binding's root (the layout's root view)
        setContentView(binding.root)


        // Customize the status bar appearance (color and text)
        changeColorStatusBar()

        // Initialize SharedPreferences with the name "DriverDocuments"
        sharedPref = getSharedPreferences("DriverDocuments", MODE_PRIVATE)


        binding.DL.setOnClickListener {
            val intent = Intent(this, DrivingLicenceUpload::class.java)
            startActivity(intent)
        }

        binding.adhar.setOnClickListener {
            val intent = Intent(this, AdharCardUpload::class.java)
            startActivity(intent)
        }

        binding.panCad.setOnClickListener {
            val intent = Intent(this, PanCardUpload::class.java)
            startActivity(intent)
        }

        binding.RC.setOnClickListener {
            val intent = Intent(this, RcUpload::class.java)
            startActivity(intent)
        }

        binding.insurance.setOnClickListener {
            val intent = Intent(this, VehicleInsurance::class.java)
            startActivity(intent)
        }

        binding.permit.setOnClickListener {
            val intent = Intent(this, VehiclePermit::class.java)
            startActivity(intent)
        }

//        binding.nextBtn.setOnClickListener {
//            val intent = Intent(this, MapsLocation::class.java)
//            startActivity(intent)
//        }

        // Call onResume() to check and update the UI based on SharedPreferences data
        onResume()
    }

    // Override the onResume() method to refresh the UI every time the activity is resumed
    override fun onResume() {
        super.onResume()

        // Re-check if the Driving documents section is complete
        val isDrivingLicenseComplete = sharedPref.getBoolean("isDrivingLicenseComplete", false)
        val isAdharCardComplete = sharedPref.getBoolean("isAdharCardComplete", false)
        val isPanCardComplete = sharedPref.getBoolean("isPanCardComplete", false)
        val isRCComplete = sharedPref.getBoolean("isRCComplete", false)
        val isVehicleInsuranceComplete = sharedPref.getBoolean("isVehicleInsuranceComplete", false)
        val isVehiclePermitComplete = sharedPref.getBoolean("isVehiclePermitComplete", false)

        // Show or hide the right tick based on whether each section is complete
        binding.rightTickDl.visibility = if (isDrivingLicenseComplete) View.VISIBLE else View.GONE
        binding.rightTickDl2.visibility = if (isAdharCardComplete) View.VISIBLE else View.GONE
        binding.rightTickDl3.visibility = if (isPanCardComplete) View.VISIBLE else View.GONE
        binding.rightTickDl4.visibility = if (isRCComplete) View.VISIBLE else View.GONE
        binding.rightTickDl5.visibility = if (isVehicleInsuranceComplete) View.VISIBLE else View.GONE
        binding.rightTickDl6.visibility = if (isVehiclePermitComplete) View.VISIBLE else View.GONE

        // Log the current completion status
        Log.d("DriverDocuments", "Driving License Complete: $isDrivingLicenseComplete")
        Log.d("DriverDocuments", "Aadhar Card Complete: $isAdharCardComplete")
        Log.d("DriverDocuments", "Pan Card Complete: $isPanCardComplete")
        Log.d("DriverDocuments", "RC Complete: $isRCComplete")
        Log.d("DriverDocuments", "Vehicle Insurance Complete: $isVehicleInsuranceComplete")
        Log.d("DriverDocuments", "Vehicle Permit Complete: $isVehiclePermitComplete")


        // If all the documents are uploaded then it will continue otherwise a toast will be shown
        binding.continueBtn.setOnClickListener {
            if (isDrivingLicenseComplete && isAdharCardComplete && isPanCardComplete && isRCComplete &&
            isVehicleInsuranceComplete && isVehiclePermitComplete) {
                val intent = Intent(this, MapsLocation::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please complete all documents before continuing", Toast.LENGTH_SHORT).show()
            }
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
}