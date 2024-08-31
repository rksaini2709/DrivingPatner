plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.dirvingpatner"
    compileSdk = 34

    packagingOptions{
        exclude("META-INF/DEPENDENCIES")
    }

    defaultConfig {
        applicationId = "com.example.dirvingpatner"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.messaging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //text dimension
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    //country code picker
    implementation ("com.hbb20:ccp:2.7.1")

    //circule image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //pin view
    implementation ("io.github.chaosleung:pinview:1.4.4")

    // google map
    implementation ("com.google.android.gms:play-services-maps:18.0.2")
    implementation ("com.google.android.gms:play-services-location:21.0.1")

    // side drawer
    implementation ("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))

    // Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics:19.0.0")


    // Google Auth Library for OAuth2 HTTP
    // This library is used to manage OAuth 2.0 authentication and authorization.
    // It helps in generating access tokens, managing token lifecycles and making authenticated requests to Google APIs.
    implementation ("com.google.auth:google-auth-library-oauth2-http:1.19.0")
}