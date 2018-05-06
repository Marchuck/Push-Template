package pl.marczak.pushtemplate.service

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.lang.Exception

class HandlePushMessagesService : FirebaseMessagingService() {

    companion object {
        val TAG = HandlePushMessagesService::class.java.simpleName!!
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage?.getFrom());

        // Check if message contains a data payload.
        val data = remoteMessage?.data
        val size = data?.size ?: 0
        if (size > 0) {

            val expr = "Message data payload: $data"
            Log.d(TAG, expr)

            showToast(expr)

        }

        // Check if message contains a notification payload.
        if (remoteMessage?.notification != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.notification.body)
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    override fun handleIntent(p0: Intent?) {
        super.handleIntent(p0)
    }

    override fun onMessageSent(p0: String?) {
        super.onMessageSent(p0)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }

    override fun onSendError(p0: String?, p1: Exception?) {
        super.onSendError(p0, p1)
    }
}


fun Context.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}