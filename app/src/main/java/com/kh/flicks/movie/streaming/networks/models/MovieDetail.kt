package com.kh.flicks.movie.streaming.networks.models

data class MovieDetail(
	var id: Int?,
	var title: String?,
	var image: Int?,
	var desc: String?,
	var releaseDate: String?,
	var rating: Double?,
	var category: String?
)
