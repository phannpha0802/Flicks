package com.kh.flicks.movie.streaming.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySignUpBinding

	companion object {
		fun newIntent(activity: Activity?) {
			activity?.startActivity(Intent(activity, SignUpActivity::class.java))
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this@SignUpActivity, R.layout.activity_sign_up)

		initObject()
	}

	private fun initObject(){
		buttonBack()
		navToSignIn()
	}

	private fun buttonBack(){
		binding.btnBack.setOnClickListener{
			finish()
		}
	}

	private fun navToSignIn(){
		binding.tvSignIn.setOnClickListener {
			SignInActivity.newIntent(this)
			finish()
		}
	}
}