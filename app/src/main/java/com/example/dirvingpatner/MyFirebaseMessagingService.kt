package com.example.dirvingpatner

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

// This class handles Firebase Cloud Messaging (FCM) services, including receiving messages
// and handling token refreshes.
class MyFirebaseMessagingService : FirebaseMessagingService() {

    // This method is called whenever a new message is received from FCM.
    // The message can contain data and/or a notification payload.
    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        // Log the sender of the message (useful for debugging).
        Log.d("FCM Message", "From: ${remoteMessage.from}")

        // Check if the message contains a data payload (key-value pairs).
        if (remoteMessage.data.isNotEmpty()) {

            // Log the data payload of the message.
            Log.d("MyFirebaseMsgService", "Message data payload: ${remoteMessage.data}")

            // Here you can handle the data payload, e.g., update the app's UI or database.
        }

        // Check if the message contains a notification payload (a notification to be displayed to the user).
        remoteMessage.notification?.let {
            // Log the body of the notification message.
            Log.d("MyFirebaseMsgService", "Message Notification Body: ${it.body}")

            // Here you can display the notification or handle it as needed.
        }
    }

    // This method is called when a new token is generated for the device.
    // The token is used to uniquely identify the device so that it can receive messages from FCM.
    override fun onNewToken(token: String) {

        // Log the new token for debugging purposes.
        Log.d("FCM Token", "Refreshed token: $token")

        // Send the token to your server so it can be associated with the user/device.
        sendRegistrationToServer(token)
    }

    // This method is used to send the token to your server.
    // Replace the body of this method with code to send the token to your backend.
    private fun sendRegistrationToServer(token: String) {

        // Log that the token is being sent to the server.
        Log.d("MyFirebaseMsgService", "Sending token to server: $token")

        // Implement the network request here to send the token to your server.
    }
}