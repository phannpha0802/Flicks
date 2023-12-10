package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivitySearchedMovieBinding
import com.kh.flicks.movie.streaming.extensions.hideSoftKeyboard

class SearchedMovieActivity : AppCompatActivity() {
	private lateinit var binding: ActivitySearchedMovieBinding

	companion object{
		fun newIntent(activity: Activity?, text: String?){
			activity?.startActivity(Intent(activity, SearchedMovieActivity::class.java).apply {
				putExtra("data",text)
			})
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(
			this@SearchedMovieActivity,
			R.layout.activity_searched_movie
		)

		val bundle: Bundle? = intent.extras
		val text = bundle?.getString("data").toString()
		searchField(text)
		buttonCancel()
		hideSoftKeyboardFromWindow()
		binding.containerSearchNotFound.visibility = View.VISIBLE
	}

	private fun searchField(text: String) {
		val searchView = binding.searchField
		searchView.setText(text)
	}

	private fun buttonCancel() {
		binding.buttonCancel.setOnClickListener {
			binding.searchField.text = null
		}
	}

	private fun hideSoftKeyboardFromWindow() {
		binding.mainSearchContainer.setOnClickListener {
			hideSoftKeyboard()
		}
	}
}