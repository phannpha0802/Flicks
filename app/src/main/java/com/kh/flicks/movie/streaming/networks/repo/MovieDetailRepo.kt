package com.kh.flicks.movie.streaming.networks.repo

import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.networks.models.Slider

// Movie detail repository : cover on inserting data, and getting data.
class MovieDetailRepo {
	private val movieDetailRepo = ArrayList<MovieDetail>()

	fun addSlider(detail: MovieDetail) {
		movieDetailRepo.add(detail)
	}

	fun getAllSlider(): ArrayList<MovieDetail> {
		return movieDetailRepo
	}
}