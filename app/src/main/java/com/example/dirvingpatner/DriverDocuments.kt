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

class DriverDocuments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_documents)

        val DL = findViewById<View>(R.id.DL)
        val Aadhar = findViewById<View>(R.id.adhar)
        val Pan = findViewById<View>(R.id.panCad)
        val RC = findViewById<View>(R.id.RC)
        val Insurance = findViewById<View>(R.id.insurance)
        val Permit = findViewById<View>(R.id.permit)

        DL.setOnClickListener {
            val intent = Intent(this, DrivingLicenceUpload::class.java)
            startActivity(intent)
        }

        Aadhar.setOnClickListener {
            val intent = Intent(this, AdharCardUpload::class.java)
            startActivity(intent)
        }

        Pan.setOnClickListener {
            val intent = Intent(this, PanCardUpload::class.java)
            startActivity(intent)
        }

        RC.setOnClickListener {
            val intent = Intent(this, RcUpload::class.java)
            startActivity(intent)
        }

        Insurance.setOnClickListener {
            val intent = Intent(this, VehicleInsurance::class.java)
            startActivity(intent)
        }

        Permit.setOnClickListener {
            val intent = Intent(this, VehiclePermit::class.java)
            startActivity(intent)
        }
    }
}