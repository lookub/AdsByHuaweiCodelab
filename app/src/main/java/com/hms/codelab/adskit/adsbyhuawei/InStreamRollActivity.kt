package com.hms.codelab.adskit.adsbyhuawei

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.MediaMuteListener
import com.huawei.hms.ads.instreamad.*
import java.util.*

class InStreamRollActivity : AppCompatActivity(), View.OnClickListener{

    private val TAG = InStreamRollActivity::class.java.simpleName

   // TODO : create InstreamView

   // TODO : create List<InstreamAd>

   // TODO : create InstreamAdLoader

   // TODO : create InstreamAdLoadListener

   // TODO : create InstreamMediaChangeListener

   // TODO : create InstreamMediaStateListener

   // TODO : create InstreamMediaStateListener

    private lateinit var instreamContainer: RelativeLayout
    private lateinit var whyThisAd: ImageView

    private lateinit var videoContent: TextView
    private lateinit var skipAd: MaterialButton
    private lateinit var countDown: TextView
    private lateinit var callToAction: MaterialButton

    private lateinit var loadButton: MaterialButton
    private lateinit var registerButton: MaterialButton
    private lateinit var muteButton: MaterialButton
    private lateinit var pauseButton: MaterialButton

    private var maxAdDuration = 0
    private lateinit var whyThisAdUrl: String
    private var isMuted = false

    private lateinit var btnCreateInStreamAd: MaterialButton
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_stream_roll)

        setupToolbar()
        initializeUiViews()

        // create and initialize order can be like below.

        // TODO : call createInstreamAdLoadListener
        createInstreamAdLoadListener()

        // TODO : call createInStreamMediaChangeListener
        createInStreamMediaChangeListener()

        // TODO : call createInStreamMediaStateListener
        createInStreamMediaStateListener()

        // TODO : call createMediaMuteListener
        createMediaMuteListener()



        // TODO : call createInStreamAdLoader
        createInStreamAdLoader()

        // TODO : call initializeInstreamAdView
        initializeInstreamAdView()

        // TODO : call loadInStreamAd
        loadInStreamAd()
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

    private fun initializeUiViews() {
        btnCreateInStreamAd = findViewById(R.id.btnCreateInStreamAd)
        btnCreateInStreamAd.setOnClickListener(this)
        instreamContainer = findViewById(R.id.instream_ad_container)
        videoContent = findViewById(R.id.instream_video_content)
        countDown = findViewById(R.id.instream_count_down)
        callToAction = findViewById(R.id.instream_call_to_action)
        whyThisAd = findViewById(R.id.instream_why_this_ad)
        loadButton = findViewById(R.id.instream_load)
        registerButton = findViewById(R.id.instream_register)
        muteButton = findViewById(R.id.instream_mute)
        pauseButton = findViewById(R.id.instream_pause_play)
        loadButton.setOnClickListener(this)
        registerButton.setOnClickListener(this)
        muteButton.setOnClickListener(this)
        pauseButton.setOnClickListener(this)
        skipAd = findViewById(R.id.instream_skip)

        skipAd.setOnClickListener {
            // TODO : skipAd InStreamAd
        }
    }


    // TODO : Initialize InstreamAdView
    private fun initializeInstreamAdView() {
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCreateInStreamAd -> {
               //if (instreamView == null) {
               //    initializeInstreamAdView()
               //}
               //createInStreamAdLoader()
               //loadInStreamAd()
            }
            R.id.instream_load -> loadInStreamAd()
            R.id.instream_register -> {
                //if (null == instreamAds || instreamAds.isEmpty()) {
                //    playNormalVideo()
                //} else {
                //    playInstreamAds(instreamAds)
                //}
            }
            R.id.instream_mute -> {
                //if (isMuted) {
                //    instreamView.unmute()
                //    muteButton.text = "Mute"
                //} else {
                //    instreamView.mute()
                //    muteButton.text = "UnMute"
                //}
            }
            R.id.instream_pause_play -> {
                //if (instreamView.isPlaying) {
                //    instreamView.pause()
                //    pauseButton.text = "Play"
                //} else {
                //    instreamView.play()
                //    pauseButton.text = "Pause"
                //}
            }
        }
    }


    // TODO : Initialize InstreamAdLoader
    private fun createInStreamAdLoader() {
    }

    // TODO : Initialize InstreamAdLoadListener
    private fun createInstreamAdLoadListener(){
    }

    // TODO : Initialize InstreamMediaChangeListener
    private fun createInStreamMediaChangeListener() {
    }

    // TODO : Initialize InstreamMediaStateListener
    private fun createInStreamMediaStateListener(){
    }

    // TODO : Initialize InstreamMediaMuteListener
    private fun createMediaMuteListener(){
    }

    // TODO : load InStreamAd
    private fun loadInStreamAd() {
    }


    private fun showAdButtons() {
        muteButton.visibility = View.VISIBLE
        pauseButton.visibility = View.VISIBLE
        registerButton.visibility = View.GONE
    }

    private fun hideAdButtons() {
        muteButton.visibility = View.GONE
        pauseButton.visibility = View.GONE
        registerButton.visibility = View.VISIBLE
    }

    private fun showLoadAndCreateAdButtons() {
        loadButton.visibility = View.VISIBLE
        btnCreateInStreamAd.visibility = View.VISIBLE
    }

    private fun hideLoadAndCreateAdButtons() {
        loadButton.visibility = View.GONE
        btnCreateInStreamAd.visibility = View.GONE
    }


    // play your normal video content.
    private fun playNormalVideo() {
        Log.d(TAG, "playNormalVideo")
        hideAdViews()
        videoContent.text = "Normal Video Playing..."
    }

    private fun hideAdViews() {
        instreamContainer.visibility = View.GONE
    }

    // TODO : display InStreamAd
    private fun playInstreamAds(ads: List<InstreamAd>) {
        Log.d(TAG, "playInstreamAds")
        maxAdDuration = getMaxInstreamDuration(ads)
        instreamContainer.visibility = View.VISIBLE
        loadButton.text = "Load Ad"
        //instreamView.setInstreamAds(ads)
        showAdButtons()
    }

    private fun updateCountDown(playTime: Long) {
        val time =
            Math.round((maxAdDuration - playTime) / 1000.toFloat()).toString()
        runOnUiThread { countDown.text = time + "s" }
    }

    private fun getMaxInstreamDuration(ads: List<InstreamAd>): Int {
        var duration = 0
        for (ad in ads) {
            duration += ad.duration.toInt()
        }
        return duration
    }

    // TODO : destroy instreamView when onDestroy

}