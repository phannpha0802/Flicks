package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemFavoriteBinding

class ItemFavoriteActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemFavoriteBinding

	companion object{
		fun newIntent(activity: Activity?){
			activity?.startActivity(Intent(activity, ItemDetailActivity::class.java))
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_favorite)

		// TODO: code here.
	}
}