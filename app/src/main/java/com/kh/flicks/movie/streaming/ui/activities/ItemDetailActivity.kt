package com.kh.flicks.movie.streaming.ui.activities

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemDetailBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.utils.Util

class ItemDetailActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemDetailBinding

	@RequiresApi(Build.VERSION_CODES.TIRAMISU)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)

		// TODO: code here.
		buttonBack()

		val bundle: Bundle? = intent.extras
		val movie = bundle?.getParcelable("data", MovieDetail::class.java)
		detailInfo(movie!!)
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