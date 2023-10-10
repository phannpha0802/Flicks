package com.kh.flicks.movie.streaming.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemFavoriteBinding

class ItemFavoriteActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemFavoriteBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_favorite)

		// TODO: code here.
	}
}