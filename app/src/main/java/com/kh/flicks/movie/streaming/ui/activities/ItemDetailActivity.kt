package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemDetailBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.utils.Util

class ItemDetailActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemDetailBinding
	private lateinit var movieDetailString: String
	private lateinit var movieDetailResponseObject: MovieDetail

	companion object {
		fun newIntent(activity: Activity?, movie: String){
			activity?.startActivity(Intent(activity, ItemDetailActivity::class.java).apply {
				putExtra("data", movie)
			})
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
		initObject()
		buttonBack()
	}

	private fun initObject(){
		movieDetailString = intent.getStringExtra("data").toString()
		movieDetailResponseObject = Gson().fromJson(movieDetailString, MovieDetail::class.java)
		Log.d("TAG", "initObject: ${movieDetailResponseObject.title}")
	}

	private fun buttonBack() {
		binding.buttonBack.setOnClickListener { finish() }
	}

	private fun detailInfo(movie: MovieDetail) {
		binding.titleMovie.text = Util.capitalize(movie.title.toString())
		binding.descMovie.text = movie.desc.toString()
		binding.categoryMovie.text = Util.capitalize(movie.category.toString())
		binding.ratingItem.text = movie.rating.toString()
		binding.releaseDate.text = Util.capitalize("2023")
		binding.durationMovie.text = Util.capitalize("120 Minutes")
		localImage(movie.image ?: R.drawable.profile_image, binding.imageBack)
		localImage(movie.image ?: R.drawable.profile_image, binding.imageFront)
	}
}