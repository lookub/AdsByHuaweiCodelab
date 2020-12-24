package com.hms.codelab.adskit.adsbyhuawei

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class BannerActivity : AppCompatActivity() {

    private val TAG = BannerActivity::class.java.simpleName

    // TODO : create listeners

    // TODO : create BannerView

    // TODO : create FrameLayout

    private val REFRESH_TIME = 5
    private lateinit var loadAd: MaterialButton
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        setupToolbar()
        initializeUI()

        // TODO : call createAdListener
        createAdListener()

    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }


    private fun initializeUI() {
        // TODO : initialize FrameLayout

        // TODO : initialize BannerView

        loadAd = findViewById(R.id.btnLoadBannerAd)
        loadAd.setOnClickListener { loadBannerAd() }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun createAdListener() {
        // TODO : initialize AdListener
    }

    private fun loadBannerAd() {
        // TODO : customize and load BannerAd
    }

}