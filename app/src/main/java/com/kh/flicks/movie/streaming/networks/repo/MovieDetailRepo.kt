package com.kh.flicks.movie.streaming.networks.repo

import com.kh.flicks.movie.streaming.networks.models.MovieDetail

// Movie detail repository : cover on inserting data, and getting data.
class MovieDetailRepo {
	private val movieDetailRepo = ArrayList<MovieDetail>()

	fun clearList() {
		movieDetailRepo.clear()
	}

	fun addMovieDetail(detail: MovieDetail) {
		movieDetailRepo.add(detail)
	}

	fun getMovieDetail(): ArrayList<MovieDetail> {
		return movieDetailRepo
	}
}