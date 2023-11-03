package com.kh.flicks.movie.streaming.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.networks.repo.CategoryRepo
import com.kh.flicks.movie.streaming.networks.repo.MovieDetailRepo
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

	// create mapping data class for search fragment
	data class SearchData(
		val category: ArrayList<Category>,
		val itemToday: ArrayList<MovieDetail>,
		val itemRecommend: ArrayList<MovieDetail>
	)

	// create static object to access necessary method
	companion object {
		private val _categoryRepo = CategoryRepo()
		private val _itemTodayRepo = MovieDetailRepo()
		private val _itemRecommendRepo = MovieDetailRepo()
	}

	// create state to observe data change
	private val _uiState = MutableLiveData<SearchData>()

	//create state to update ui
	val uiState: LiveData<SearchData> get() = _uiState

	// create network request.
	private fun getCategoryFormNetwork() {
		val list = ArrayList<Category>()
		list.add(Category(1, "All"))
		list.add(Category(2, "Comedy"))
		list.add(Category(3, "Animation"))
		list.add(Category(4, "Document"))
		list.add(Category(5, "KDrama"))

		_categoryRepo.clearList()
		for (item in list) {
			_categoryRepo.addCategory(item)
		}
	}

	// create network request.
	private fun getTodayItemFormNetwork() {
		val list = ArrayList<MovieDetail>()
		list.add(
			MovieDetail(
				3,
				"The boy fly to the moon.",
				R.drawable.carousel_image_1,
				"This is the story that talk about The boy fly to the moon.",
				"20 Oct, 2021",
				4.3,
				"Animation"
			)
		)

		_itemTodayRepo.clearList()
		for (item in list) {
			_itemTodayRepo.addMovieDetail(item)
		}
	}

	// create network request.
	private fun getRecommendItemFormNetwork() {
		val list = ArrayList<MovieDetail>()
		list.add(
			MovieDetail(
				1,
				"The handsome boy in my school.",
				R.drawable.profile_image,
				"This is the story that talk about the handsome boy in my school.",
				"12 November, 2023",
				3.4,
				"Animation"
			)
		)
		list.add(
			MovieDetail(
				2,
				"The boy fly to the moon.",
				R.drawable.carousel_image_2,
				"This is the story that talk about The boy fly to the moon.",
				"20 Oct, 2021",
				4.0,
				"Animation"
			)
		)
		list.add(
			MovieDetail(
				3,
				"The boy fly to the moon.",
				R.drawable.carousel_image_1,
				"This is the story that talk about The boy fly to the moon.",
				"20 Oct, 2021",
				4.3,
				"Animation"
			)
		)

		_itemRecommendRepo.clearList()
		for (item in list) {
			_itemRecommendRepo.addMovieDetail(item)
		}
	}

	init {

		// mock data.
		getCategoryFormNetwork()
		getTodayItemFormNetwork()
		getRecommendItemFormNetwork()

		viewModelScope.launch {
			_uiState.value = SearchData(
				_categoryRepo.getAllCategory(),
				_itemTodayRepo.getMovieDetail(),
				_itemRecommendRepo.getMovieDetail()
			)
		}
	}
}