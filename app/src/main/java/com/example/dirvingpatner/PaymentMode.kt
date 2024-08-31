package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dirvingpatner.databinding.ActivityPaymentModeBinding

class PaymentMode : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentModeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentModeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()


        // Explicitly navigate back to the DriverDocuments activity
        val intent = Intent(this, MapsLocation::class.java)


        // Clear the current activity and bring the DriverDocuments activity to the front
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish() // Finish the current activity
    }
}