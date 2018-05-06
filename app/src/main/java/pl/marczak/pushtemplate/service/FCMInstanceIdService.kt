package pl.marczak.pushtemplate.service

import android.content.Intent
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService


class FCMInstanceIdService : FirebaseInstanceIdService() {

    companion object {
        val TAG = FCMInstanceIdService::class.java.simpleName
    }


    override fun handleIntent(p0: Intent?) {
        print("handleIntent $p0")
        super.handleIntent(p0)
    }

    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken)
    }

    private fun sendRegistrationToServer(refreshedToken: String) {

    }
}
