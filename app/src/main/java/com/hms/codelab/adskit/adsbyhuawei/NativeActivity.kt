package com.hms.codelab.adskit.adsbyhuawei

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.nativead.NativeAd
import com.huawei.hms.ads.nativead.NativeView

class NativeActivity : AppCompatActivity() {

    private val TAG = NativeActivity::class.java.simpleName

    // TODO : create NativeView for smallNativeView

    // TODO : create NativeView for largeNativeView

    // TODO : create NativeView for videoNativeView

    // TODO : create VideoLifecycleListener for videoNativeView

    // TODO : create AdListener
    private lateinit var adListener: AdListener

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        setupToolbar()

        // TODO : Initialize NativeView


        // TODO : call createAdListener
        createNativeAdListener()
        // TODO : call createVideoLifecycleListener
        createVideoLifecycleListener()

        // TODO : call load ads with ad id
        //loadAd(getString(R.string.ad_id_native_video), videoNativeView)
        //loadAd(getString(R.string.ad_id_native_small), smallNativeView)
        //loadAd(getString(R.string.ad_id_native), largeNativeView)
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    // TODO : Initialize AdListener
    private fun createNativeAdListener() {

        adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d(TAG,"adListener.onAdLoaded")
                Utils.showToast(applicationContext,"Ad loaded ")
            }

            override fun onAdFailed(errorCode: Int) {
                val errorMessage =
                    AdvancedAdUtils.getDetailsFromErrorCode(errorCode)
                Log.e(TAG,"NativeAd.onAdFailed() with errorMessage $errorMessage")
                Utils.showToast(applicationContext,"NativeAd onAdFailed with $errorMessage")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d(TAG,"adListener.onAdClosed")
            }

            override fun onAdClicked() {
                Log.d(TAG,"adListener.onAdClicked")
                Utils.showToast(applicationContext,"onAdClicked")
                super.onAdClicked()
            }

            override fun onAdOpened() {
                Log.d(TAG,"adListener.onAdOpened")
                Utils.showToast(applicationContext,"onAdOpened")
                super.onAdOpened()
            }
        }
    }

    // TODO : Initialize VideoLifecycleListener
    private fun createVideoLifecycleListener() {
    }


    // TODO : initialize NativeAdLoader and nativeAd
    // with these params : (adId: String, nativeView: NativeView)
    private fun loadAd(adId: String, nativeView: NativeView) {

    }


    // TODO : create and display NativeAd
    // with these params : (nativeAd: NativeAd, nativeView: NativeView)
    private fun showNativeAd(nativeAd: NativeAd, nativeView: NativeView) {

    }

}