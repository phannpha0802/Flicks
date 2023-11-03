package com.kh.flicks.movie.streaming.listeners

import com.kh.flicks.movie.streaming.networks.models.Category

interface Onclick {
	// category event listener.
	fun onItemClickLister(item: Category)
}