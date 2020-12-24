package com.hms.codelab.adskit.adsbyhuawei

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val TAG = SplashActivity::class.java.simpleName

    // TODO : create listeners

    // TODO : create splashView

    // Ad display timeout interval, in milliseconds.
    private val AD_TIMEOUT = 4000

    // Ad display timeout message flag.
    private val MSG_AD_TIMEOUT = 1001

    /**
     * Pause flag.
     * On the splash ad screen:
     * Set this parameter to true when exiting the app to ensure that the app home screen is not displayed.
     * Set this parameter to false when returning to the splash ad screen from another screen to ensure that the app home screen can be displayed properly.
     */
    private var hasPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Utils.hideNavigationBarActivity(this)

        // TODO : call Listeners
        createAdLoadListener()
        createAdDisplayListener()

        // TODO : Initialize the HUAWEI Ads SDK.

        // TODO : call loadAd
        loadAd()
    }


    // TODO : create createAdDisplayListener
    private fun createAdDisplayListener() {
    }

    // TODO : create createAdLoadListener
    private fun createAdLoadListener() {
    }

    // TODO : load Ad
    private fun loadAd() {


        // Remove the timeout message from the message queue.
        timeoutHandler.removeMessages(MSG_AD_TIMEOUT)
        // Send a delay message to ensure that the app home screen can be displayed when the ad display times out.
        timeoutHandler.sendEmptyMessageDelayed( MSG_AD_TIMEOUT, AD_TIMEOUT.toLong() )
    }

    /**
     * Switch from the splash ad screen to the app home screen when the ad display is complete.
     */
    private fun jump() {
        Log.i(TAG, "jump hasPaused: $hasPaused")
        if (!hasPaused) {
            hasPaused = true
            Log.i(TAG, "jump into application")
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.postDelayed({ finish() }, 1000)
        }
    }

    // Callback handler used when the ad display timeout message is received.
    private val timeoutHandler =
        Handler(Looper.getMainLooper(), Handler.Callback {
            if (hasWindowFocus()) {
                jump()
            }
            false
        })


    /**
     * Set this parameter to true when exiting the app to ensure that the app home screen is not displayed.
     */
    override fun onStop() {
        Log.i(TAG, "SplashActivity onStop.")
        hasPaused = true
        // Remove the timeout message from the message queue.
        timeoutHandler.removeMessages(MSG_AD_TIMEOUT)
        super.onStop()
    }

    /**
     * Call this method when returning to the splash ad screen from another screen to access the app home screen.
     */
    override fun onRestart() {
        Log.i(TAG, "SplashActivity onRestart.")
        super.onRestart()
        hasPaused = false
        jump()
    }

}