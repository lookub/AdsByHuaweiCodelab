package com.hms.codelab.adskit.adsbyhuawei

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class InterstitialActivity : AppCompatActivity() {

    private val TAG = InterstitialActivity::class.java.simpleName

    // TODO : create listeners

    // TODO : create InterstitialAd

    private lateinit var toolbar: Toolbar
    private lateinit var refresh: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)

        setupToolbar()
        initializeUI()

        // TODO : call createInterstialAdListeners
        createInterstialAdListeners()

        // TODO : call loadInterstitialAd
        loadInterstitialAd()

    }

    // TODO : Initialize listeners
    private fun createInterstialAdListeners() {
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

    private fun initializeUI() {
        refresh = findViewById(R.id.btnRefreshInterstitial)
        refresh.setOnClickListener { loadInterstitialAd() }
    }

    // TODO : initialize InterstitialAd
    private fun loadInterstitialAd() {
    }

    // TODO : Display an interstitial ad when its loaded
    private fun showInterstitial() {
    }


}