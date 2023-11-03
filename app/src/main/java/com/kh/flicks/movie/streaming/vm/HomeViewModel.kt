package com.kh.flicks.movie.streaming.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.networks.models.Carousel
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.networks.repo.CarouselRepo
import com.kh.flicks.movie.streaming.networks.repo.CategoryRepo
import com.kh.flicks.movie.streaming.networks.repo.MovieDetailRepo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
	// create mapping data class for using in home fragment.
	data class HomeData(
		val carousel: ArrayList<Carousel>,
		val category: ArrayList<Category>,
		val popularItem: ArrayList<MovieDetail>
	)

	// create static object of class for access necessary method.
	companion object {
		private val _carouselRepo = CarouselRepo()
		private val _categoryRepo = CategoryRepo()
		private val _popularItem = MovieDetailRepo()
	}

	// create state to observe data changed
	private val _uiState = MutableLiveData<HomeData>()

	// create state to update ui
	val uiState: LiveData<HomeData> get() = _uiState

	// method to access data from network request.
	private fun getCarouselFromNetwork() {
		val list = ArrayList<Carousel>()

		list.add(
			Carousel(
				1,
				"Black Panther: Wakanda Forever",
				R.drawable.profile_image,
				"20, November 2023"
			)
		)
		list.add(
			Carousel(
				2,
				"Black Panther: Wakanda Forever",
				R.drawable.carousel_image_2,
				"10, Oct 2021"
			)
		)
		list.add(
			Carousel(
				3,
				"Black Panther: Wakanda Forever",
				R.drawable.carousel_image_1,
				"04, Aug 2020"
			)
		)
		_carouselRepo.clearList()
		for (item in list) {
			_carouselRepo.addCarousel(item)
		}
	}

	// method to access data from network request.
	private fun getCategoryFromServer() {
		val list = ArrayList<Category>()
		list.clear()
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

	// method to access data from network request.
	private fun getMovieDetailFromServer() {
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

		_popularItem.clearList()
		for (item in list) {
			_popularItem.addMovieDetail(item)
		}
	}

	init {
		// mock data
		getCarouselFromNetwork()
		getCategoryFromServer()
		getMovieDetailFromServer()

		viewModelScope.launch {
			_uiState.value = HomeData(
				_carouselRepo.getAllCarousel(),
				_categoryRepo.getAllCategory(),
				_popularItem.getMovieDetail()
			)
		}
	}
}