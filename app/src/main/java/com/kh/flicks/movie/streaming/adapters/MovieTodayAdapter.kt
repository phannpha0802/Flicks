package com.kh.flicks.movie.streaming.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ItemTodayLayoutBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.utils.Util

class MovieTodayAdapter(private val context: Activity, private val movie: ArrayList<MovieDetail>) :
	RecyclerView.Adapter<MovieTodayAdapter.ViewHolder>() {

	inner class ViewHolder(private val binding: ItemTodayLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun onBind(item: MovieDetail) {
			binding.statusMovie.text = Util.capitalize("Free")
			binding.releaseDate.text = item.releaseDate
			binding.durationMovie.text = Util.capitalize("120 Minutes")
			binding.titleMovie.text = item.title
			binding.categoryMovie.text = item.category
			binding.ratingMovie.text = item.rating.toString()
			context.localImage(item.image ?: R.drawable.profile_image, binding.imageMovie)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding: ItemTodayLayoutBinding = DataBindingUtil.inflate(
			LayoutInflater.from(parent.context),
			R.layout.item_today_layout, parent, false
		)
		return ViewHolder(binding)
	}

	override fun getItemCount(): Int {
		return movie.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(movie[position])
	}
}