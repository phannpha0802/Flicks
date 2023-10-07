package com.kh.flicks.movie.streaming.ui.auth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySignInBinding
import com.kh.flicks.movie.streaming.databinding.ActivitySignUpBinding

class SignInActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySignInBinding

	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this@SignInActivity, R.layout.activity_sign_in)

		// TODO: code here.
		binding.tvText.text = "SignIn Page"
	}
}