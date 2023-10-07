package com.kh.flicks.movie.streaming.networks.repo

import com.kh.flicks.movie.streaming.networks.models.Category

// Category repository : cover on inserting data, and getting data.
class CategoryRepo {
	private val categoryRepo = ArrayList<Category>()

	fun addCategory(category: Category) {
		categoryRepo.add(category)
	}

	fun getAllCategory(): ArrayList<Category> {
		return categoryRepo
	}
}