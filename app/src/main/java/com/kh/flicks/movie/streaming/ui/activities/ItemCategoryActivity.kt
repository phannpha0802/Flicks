package com.kh.flicks.movie.streaming.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemCategoryBinding
import com.kh.flicks.movie.streaming.extensions.toastMessage

class ItemCategoryActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemCategoryBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_category)

		// TODO: code here.
		val bundle: Bundle? = intent.extras
		val category = bundle?.getString("data").toString()
		toastMessage(category)
	}
}