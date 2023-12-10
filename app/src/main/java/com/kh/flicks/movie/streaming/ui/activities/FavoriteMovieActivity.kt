package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityFavoriteMovieBinding

class FavoriteMovieActivity : AppCompatActivity() {
	private lateinit var binding: ActivityFavoriteMovieBinding

	companion object{
		fun newIntent(activity: Activity?){
			activity?.startActivity(Intent(activity, FavoriteMovieActivity::class.java))
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_favorite_movie)

	}
}