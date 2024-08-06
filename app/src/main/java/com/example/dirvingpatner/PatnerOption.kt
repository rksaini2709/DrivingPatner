package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PatnerOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_patner_option)

        // Set the edge-to-edge behavior for the activity
        enableEdgeToEdge()

        val carOwner = findViewById<CardView>(R.id.car_owner)
        val bikeOwner = findViewById<CardView>(R.id.bike_owner)
        val commercialOwner = findViewById<CardView>(R.id.commercial_owner)
        val autoOwner = findViewById<CardView>(R.id.auto_owner)
        val bike = findViewById<CardView>(R.id.Bike)

        carOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        bikeOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        commercialOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        autoOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        bike.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

    }
}