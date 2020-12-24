package com.hms.codelab.adskit.adsbyhuawei

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.huawei.hms.ads.HwAds

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //region initializeVariables
    private lateinit var btnCreateSplashAd: MaterialButton
    private lateinit var btnCreateBannerAd: MaterialButton
    private lateinit var btnCreateInterstitialAd: MaterialButton
    private lateinit var btnCreateRewardAd: MaterialButton
    private lateinit var btnCreateNativeAd: MaterialButton
    private lateinit var btnInsStreamAdRollAd: MaterialButton
    private lateinit var ivInfo: ImageView
    //endregion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this)

        initializeUI()
    }

    private fun initializeUI() {

        btnCreateSplashAd = findViewById(R.id.btnCreateSplashAd)
        btnCreateBannerAd = findViewById(R.id.btnCreateBannerAd)
        btnCreateInterstitialAd = findViewById(R.id.btnCreateInterstitialAd)
        btnCreateRewardAd = findViewById(R.id.btnCreateRewardAd)
        btnCreateNativeAd = findViewById(R.id.btnCreateNativeAd)
        btnInsStreamAdRollAd = findViewById(R.id.btnInsStreamAdRollAd)
        ivInfo = findViewById(R.id.ivInfo)

        btnCreateSplashAd.setOnClickListener(this)
        btnCreateBannerAd.setOnClickListener(this)
        btnCreateInterstitialAd.setOnClickListener(this)
        btnCreateRewardAd.setOnClickListener(this)
        btnCreateNativeAd.setOnClickListener(this)
        btnInsStreamAdRollAd.setOnClickListener(this)
        ivInfo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreateSplashAd -> {
                createIntentAndStartActivity(SplashActivity::class.java)
                val mainHandler = Handler()
                mainHandler.postDelayed({ finish() }, 500)
            }
            R.id.btnCreateBannerAd -> createIntentAndStartActivity(BannerActivity::class.java)
            R.id.btnCreateInterstitialAd -> createIntentAndStartActivity(InterstitialActivity::class.java)
            R.id.btnCreateRewardAd -> createIntentAndStartActivity(RewardActivity::class.java)
            R.id.btnCreateNativeAd -> createIntentAndStartActivity(NativeActivity::class.java)
            R.id.btnInsStreamAdRollAd -> createIntentAndStartActivity(InStreamRollActivity::class.java)
            R.id.ivInfo -> Utils.openWebPage(this, resources.getString(R.string.link_ads_kit))
        }
    }

    private fun createIntentAndStartActivity(tClass: Class<*>?) {
        val intent = Intent(this@MainActivity, tClass)
        startActivity(intent)
    }

}