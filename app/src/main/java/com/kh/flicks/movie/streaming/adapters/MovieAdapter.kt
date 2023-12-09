package com.kh.flicks.movie.streaming.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.PopularItemLayoutBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.listeners.OnMovieClick
import com.kh.flicks.movie.streaming.networks.models.MovieDetail

class MovieAdapter(
	private val context: Activity,
	private val movie: ArrayList<MovieDetail>,
	private val onClick: OnMovieClick
) :
	RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

	inner class ViewHolder(private val binding: PopularItemLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun onBind(item: MovieDetail) {
			binding.titleItem.text = item.title
			binding.categoryItem.text = item.category
			binding.ratingItem.text = item.rating.toString()
			context.localImage(item.image ?: R.drawable.carousel_image_2, binding.imageItem)

			// movie selected listener.
			binding.imageItem.setOnClickListener {
				onClick.onItemClickListener(item)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding: PopularItemLayoutBinding = DataBindingUtil.inflate(
			LayoutInflater.from(parent.context),
			R.layout.popular_item_layout, parent, false
		)
		return ViewHolder(binding)
	}

	override fun getItemCount(): Int = movie.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(movie[position])
	}
}