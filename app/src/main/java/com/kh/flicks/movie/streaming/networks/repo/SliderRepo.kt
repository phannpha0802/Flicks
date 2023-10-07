package com.kh.flicks.movie.streaming.networks.repo

import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.Slider

// Slider repository : cover on inserting data, and getting data.
class SliderRepo {
	private val sliderRepo = ArrayList<Slider>()

	fun addSlider(slider: Slider) {
		sliderRepo.add(slider)
	}

	fun getAllSlider(): ArrayList<Slider> {
		return sliderRepo
	}
}