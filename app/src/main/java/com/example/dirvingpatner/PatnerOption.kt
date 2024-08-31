package com.example.dirvingpatner

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dirvingpatner.databinding.ActivityPatnerOptionBinding

class PatnerOption : AppCompatActivity() {

    private lateinit var binding: ActivityPatnerOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityPatnerOptionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.carOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        binding.bikeOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        binding.commercialOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        binding.autoOwner.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }

        binding.Bike.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
        }


//        val carOwner = findViewById<CardView>(R.id.car_owner)
//        val bikeOwner = findViewById<CardView>(R.id.bike_owner)
//        val commercialOwner = findViewById<CardView>(R.id.commercial_owner)
//        val autoOwner = findViewById<CardView>(R.id.auto_owner)
//        val bike = findViewById<CardView>(R.id.Bike)
//
//        carOwner.setOnClickListener {
//            val intent = Intent(this, ProfileDetails::class.java)
//            startActivity(intent)
//        }
//
//        bikeOwner.setOnClickListener {
//            val intent = Intent(this, ProfileDetails::class.java)
//            startActivity(intent)
//        }
//
//        commercialOwner.setOnClickListener {
//            val intent = Intent(this, ProfileDetails::class.java)
//            startActivity(intent)
//        }
//
//        autoOwner.setOnClickListener {
//            val intent = Intent(this, ProfileDetails::class.java)
//            startActivity(intent)
//        }
//
//        bike.setOnClickListener {
//            val intent = Intent(this, ProfileDetails::class.java)
//            startActivity(intent)
//        }

    }
}