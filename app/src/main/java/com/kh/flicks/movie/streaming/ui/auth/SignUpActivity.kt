package com.kh.flicks.movie.streaming.ui.auth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySignUpBinding

	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this@SignUpActivity, R.layout.activity_sign_up)

		// TODO: code here.
		binding.tvText.text = "SignUp Page"
	}
}