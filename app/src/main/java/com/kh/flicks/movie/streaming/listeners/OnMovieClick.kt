package com.kh.flicks.movie.streaming.listeners

import com.kh.flicks.movie.streaming.networks.models.MovieDetail

interface OnMovieClick {
	fun onItemClickListener(movie: MovieDetail)
}