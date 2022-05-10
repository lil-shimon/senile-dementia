package com.example.seniledementia.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("MyFirebaseLog", "From: ${message.from}")
        Log.d("MyFirebaseLog", "Data: ${message.data}")
        Log.d("MyFirebaseLog", "Title: ${message.notification?.title}")
        Log.d("MyFirebaseLog", "Body: ${message.notification?.body}")

        if (message.data.isNotEmpty()) {
            Log.d("MyFirebaseLog", "Body: ${message.notification?.body}")
        }
    }
}