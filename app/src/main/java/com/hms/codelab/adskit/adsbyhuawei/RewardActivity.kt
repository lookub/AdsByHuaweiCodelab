package com.hms.codelab.adskit.adsbyhuawei

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import java.util.*

class RewardActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = RewardActivity::class.java.simpleName

    // TODO : create RewardAd

    // TODO : create adStatus listener

    private lateinit var toolbar: Toolbar

    private lateinit var textViewScore: TextView
    private lateinit var btnPlayForReward: MaterialButton
    private lateinit var btnShowRewardVideo: MaterialButton

    private var score = 1
    private val defaultScore = 10
    private val PLUS_SCORE = 1
    private val MINUS_SCORE = 5
    private val RANGE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        setupToolbar();

        // TODO : call createAdListeners
        createAdListeners()

        initializeUI();

        // TODO : call createAndLoadRewardAd
        createAndLoadRewardAd();

    }

    // TODO : create adStatus listener
    private fun createAdListeners() {
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
        textViewScore = findViewById(R.id.textViewScore)
        setScore(score)
        btnPlayForReward = findViewById(R.id.btnPlayForReward)
        btnShowRewardVideo = findViewById(R.id.btnShowRewardVideo)
        btnPlayForReward.setOnClickListener(this)
        btnShowRewardVideo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnPlayForReward -> play()
            R.id.btnShowRewardVideo -> showRewardAd()
        }
    }

    // TODO : initialize RewardAd
    private fun createAndLoadRewardAd() {
    }

    // TODO : display RewardAd
    private fun showRewardAd() {
    }

    private fun setScore(score: Int) {
        textViewScore.text = "Score : $score"
    }

    private fun play() {
        // If the score is 0, a message is displayed, asking users to watch the ad in exchange for scores.
        if (score == 0) {
            Utils.showToast(applicationContext,"Watch video ad to add score")
            return
        }

        // The value 0 or 1 is returned randomly. If the value is 1, the score increases by 1. If the value is 0, the
        // score decreases by 5. If the score is a negative number, the score is set to 0.
        val random = Random().nextInt(RANGE)
        Log.d(TAG, "play.random : $random")
        if (random == 1) {
            score += PLUS_SCORE
            Utils.showToast(applicationContext, "You win！")
        } else {
            score -= MINUS_SCORE
            score = if (score < 0) 0 else score
            Utils.showToast(applicationContext, "You lose！")
        }
        setScore(score)
    }

}