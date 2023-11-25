package com.kh.flicks.movie.streaming.ui.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySplashBinding
import com.kh.flicks.movie.streaming.ui.onboard.OnboardActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySplashBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
		splash()
	}

	private fun splash() {
		Handler().postDelayed(({
			startActivity(Intent(this, OnboardActivity::class.java))
			finish()
		}), 5000)
	}
}