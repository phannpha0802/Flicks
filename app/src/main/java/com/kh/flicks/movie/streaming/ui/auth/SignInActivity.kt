package com.kh.flicks.movie.streaming.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.MainActivity
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySignInBinding
import com.kh.flicks.movie.streaming.extensions.hideSoftKeyboard

class SignInActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySignInBinding

	companion object{
		fun newIntent(activity: Activity?){
			activity?.startActivity(Intent(activity,SignInActivity::class.java))
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil
			.setContentView(this, R.layout.activity_sign_in)
		hideSoftKeyboardFromWindow()
		buttonLogin()
		buttonRegister()
	}

	private fun hideSoftKeyboardFromWindow(){
		binding.mainContainerLoginScreen.setOnClickListener {
			hideSoftKeyboard()
		}
	}

	private fun buttonLogin(){
		binding.btnLogin.setOnClickListener {
			MainActivity.newIntent(this)
			finish()
		}
	}

	private fun buttonRegister(){
		binding.tvRegister.setOnClickListener {
			SignUpActivity.newIntent(this)
		}
	}
}