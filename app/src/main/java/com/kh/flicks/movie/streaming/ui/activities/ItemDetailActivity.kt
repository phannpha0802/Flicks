package com.kh.flicks.movie.streaming.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemDetailBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)

		// TODO: code here.
	}
}