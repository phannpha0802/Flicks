package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityDetailMovieBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.networks.models.MovieEpisode
import com.kh.flicks.movie.streaming.utils.Util

class DetailMovieActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDetailMovieBinding
	private lateinit var movieDetailString: String
	private lateinit var movieDetailResponseObject: MovieDetail

	companion object {
		fun newIntent(activity: Activity?, data: String?){
			activity?.startActivity(Intent(activity, DetailMovieActivity::class.java).apply {
				putExtra("data", data)
			})
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)
		initObject()
		buttonBack()
	}

	private fun initObject(){
		movieDetailString = intent.getStringExtra("data").toString()
		movieDetailResponseObject = Gson().fromJson(movieDetailString, MovieDetail::class.java)
		Log.d("TAG", "initObject: $movieDetailResponseObject")
		detailInfo(movieDetailResponseObject)
		if (movieDetailResponseObject.episode != null){
			episodeMovie(movieDetailResponseObject.episode!!)
		}
	}

	private fun buttonBack() {
		binding.btnBack.setOnClickListener { finish() }
	}

	private fun detailInfo(movie: MovieDetail) {
		binding.titleMovie.text = Util.capitalize(movie.title.toString())
		binding.descMovie.text = movie.desc.toString()
		binding.categoryMovie.text = Util.capitalize(movie.category.toString())
		binding.ratingMovie.text = movie.rating.toString()
		binding.releaseDate.text = Util.capitalize("2023")
		binding.durationMovie.text = Util.capitalize("${movie.duration} Minutes")
		localImage(movie.image!!, binding.imageBack)
		localImage(movie.image!!, binding.imageFront)
	}

	private fun episodeMovie(episodeList : List<MovieEpisode>){
		binding.tvEpisode.text = Util.capitalize("Episode")
	}
}