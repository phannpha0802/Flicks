package com.kh.flicks.movie.streaming.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemSearchedBinding
import com.kh.flicks.movie.streaming.extensions.hideSoftKeyboard

class ItemSearchedActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemSearchedBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(
			this@ItemSearchedActivity,
			R.layout.activity_item_searched
		)

		// TODO: code here.
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