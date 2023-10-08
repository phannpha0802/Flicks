package com.kh.flicks.movie.streaming.networks.repo

import com.kh.flicks.movie.streaming.networks.models.Carousel

// Slider repository : cover on inserting data, and getting data.
class CarouselRepo {
	private val carouselRepo = ArrayList<Carousel>()

	fun addSlider(carousel: Carousel) {
		carouselRepo.add(carousel)
	}

	fun getAllSlider(): ArrayList<Carousel> {
		return carouselRepo
	}
}