package com.kh.flicks.movie.streaming.ui.onboard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityOnboardBinding

class OnboardActivity : AppCompatActivity() {
	private lateinit var binding: ActivityOnboardBinding

	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this@OnboardActivity, R.layout.activity_onboard)

		// TODO: code here.
		binding.tvText.text = "Onboard Page"
	}
}