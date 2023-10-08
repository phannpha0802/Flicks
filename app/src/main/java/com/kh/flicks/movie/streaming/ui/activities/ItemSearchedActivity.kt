package com.kh.flicks.movie.streaming.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemSearchedBinding
import com.kh.flicks.movie.streaming.extensions.toastMessage

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
		toastMessage(text)
	}
}