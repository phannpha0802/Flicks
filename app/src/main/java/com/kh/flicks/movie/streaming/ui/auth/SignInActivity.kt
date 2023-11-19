package com.kh.flicks.movie.streaming.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.MainActivity
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySignInBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this, R.layout.activity_sign_in)

		binding.btnLogin.setOnClickListener {
			MainActivity.newIntent(this)
		}
	}
}