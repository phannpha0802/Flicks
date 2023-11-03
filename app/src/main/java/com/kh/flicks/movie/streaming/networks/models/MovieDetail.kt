package com.kh.flicks.movie.streaming.networks.models

import java.io.Serializable

data class MovieDetail(g
	var id: Int?,
	var title: String?,
	var image: Int?,
	var desc: String?,
	var releaseDate: String?,
	var rating: Double?,
	var category: String?
): Serializable
