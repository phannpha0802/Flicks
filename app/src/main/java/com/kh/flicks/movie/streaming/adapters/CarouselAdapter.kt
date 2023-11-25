package com.kh.flicks.movie.streaming.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.CarouselLayoutBinding
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.networks.models.Carousel

class CarouselAdapter(private val context: Activity, private val category: ArrayList<Carousel>) :
	RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

	inner class ViewHolder(private val binding: CarouselLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun onBind(item: Carousel) {
			context.localImage(item.image ?: R.drawable.carousel_image_2, binding.imageCarousel)
			binding.titleCarousel.text = item.title
			binding.releaseDateCarousel.text = item.releaseDate
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding: CarouselLayoutBinding =
			DataBindingUtil.inflate(
				LayoutInflater.from(parent.context),
				R.layout.carousel_layout,
				parent,
				false
			)
		return ViewHolder(binding)
	}

	override fun getItemCount(): Int = category.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(category[position])
	}
}