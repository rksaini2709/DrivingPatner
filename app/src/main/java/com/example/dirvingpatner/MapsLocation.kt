package com.example.dirvingpatner

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dirvingpatner.databinding.ActivityMapsLocationBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.navigation.NavigationView
import com.google.firebase.messaging.FirebaseMessaging

class MapsLocation : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapsLocationBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Customize the status bar appearance (color and text)
        changeColorStatusBar()

        // Initialize drawerLayout and navView using binding
        drawerLayout = binding.drawerLayout
        navView = binding.navView

        // Set up the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        binding.acceptBtn.setOnClickListener {
            // Accept Ride toast
            Toast.makeText(this, "Ride Accepted", Toast.LENGTH_SHORT).show()

            // Intent to PaymentMode Activity
            val intent = Intent(this, PaymentMode::class.java)
            startActivity(intent)
        }

        // Set up the drawer toggle
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle navigation view item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    // Handle the first item
                }
                R.id.nav_item2 -> {
                    // Handle the second item
                }
                R.id.nav_item3 -> {
                    // Handle the third item
                }
                R.id.nav_item4 -> {
                    // Handle the fourth item
                }
                R.id.nav_item5 -> {
                    // Handle the fifth item
                }
            }
            drawerLayout.closeDrawers()
            true
        }

        // Initialize BottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(binding.cardView)

        // Optionally set initial state
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // Adjust peek height
        bottomSheetBehavior.peekHeight = resources.getDimensionPixelSize(R.dimen.peek_height)


        // Initialize the SupportMapFragment and request notification when the map is ready to be used
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Initialize FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Get the FCM token
            val token = task.result
            Log.d("FCM", "FCM Token: $token")

            // You can now send this token to your server or use it as needed
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Check if location permission is granted
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request location permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        // Enable the my-location layer on the map
        mMap.isMyLocationEnabled = true

        // Get the current location
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    val currentLatLng = LatLng(it.latitude, it.longitude)
                    mMap.addMarker(MarkerOptions().position(currentLatLng).title("You are here"))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onMapReady(mMap)
            } else {
                // Permission denied, show a message to the user
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
