package com.hms.codelab.adskit.adsbyhuawei

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import java.util.*

class Utils {

    companion object {

        private val TAG =
            Utils::class.java.simpleName

        fun showToast(
            context: Context?,
            message: String?
        ) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        /**
         * @param max
         * @param min
         * @return randomNumber between min - max
         */
        fun getRandomNumber(max: Int, min: Int): Int {
            val randomNum = Random()
                .nextInt(max - min + 1) + min //  rand.nextInt((max - min) + 1) + min;
            Log.d(TAG, "getRandomNumber.randomNum : $randomNum")
            return randomNum
        }

        /**
         *
         * @param activityRef
         */
        fun hideNavigationBarActivity(activityRef: Activity) {
            val view = activityRef.window.decorView
            view.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            activityRef.window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        /**
         *
         * @param activity
         * @param url
         */
        fun openWebPage(activity: Activity, url: String?) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            activity.startActivity(browserIntent)
        }
    }

}