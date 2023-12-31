package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.gson.Gson
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.CarouselAdapter
import com.kh.flicks.movie.streaming.adapters.CategoryMovieAdapter
import com.kh.flicks.movie.streaming.adapters.MovieAdapter
import com.kh.flicks.movie.streaming.databinding.FragmentHomeBinding
import com.kh.flicks.movie.streaming.extensions.autoScroll
import com.kh.flicks.movie.streaming.extensions.hideSoftKeyboard
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.listeners.OnMovieClick
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Carousel
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.ui.activities.CategoryMovieActivity
import com.kh.flicks.movie.streaming.ui.activities.DetailMovieActivity
import com.kh.flicks.movie.streaming.ui.activities.FavoriteMovieActivity
import com.kh.flicks.movie.streaming.ui.activities.SearchedMovieActivity
import com.kh.flicks.movie.streaming.utils.Util
import com.kh.flicks.movie.streaming.vm.HomeViewModel
import kotlinx.coroutines.launch
import kotlin.math.abs

class HomeFragment(private val context: Activity) : Fragment(R.layout.fragment_home) {
	private lateinit var binding: FragmentHomeBinding
	private lateinit var homeViewModel: HomeViewModel

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentHomeBinding.bind(view)
		initObject()
		observeViewModel()
	}

	private fun initObject() { // init all object
		homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
		hideSoftKeyboardFromWindow()
		appBar()
		searchField()
		buttonFavorite()
	}

	private fun observeViewModel() {  // observe view model.
		lifecycleScope.launch {
			homeViewModel.uiState.observe(viewLifecycleOwner) { item ->
				imageCarousel(item.carousel)
				initCategoryAdapter(item.category)
				initPopularMovieAdapter(item.popularItem)
			}
		}
	}

	private fun hideSoftKeyboardFromWindow() {
		binding.mainContainerHomeFragment.setOnClickListener {
			context.hideSoftKeyboard()
		}
	}

	@SuppressLint("SetTextI18n")
	private fun appBar() {  // top bar
		context.localImage(R.drawable.profile_img, binding.profileImageHomeFragment)
		binding.userNameHomeFragment.text = Util.capitalize("Hello, Davide!")
		binding.greetingTextHomeFragment.text = "Let's stream your favorite movies."
	}

	private fun buttonFavorite() { // button favorite.
		binding.buttonFavoriteHomeFragment.setOnClickListener {
			FavoriteMovieActivity.newIntent(context)
		}
	}

	private fun searchField() { // search field.
		binding.searchFieldHomeFragment.setOnEditorActionListener { _, actionId, _ ->
			if (actionId == EditorInfo.IME_ACTION_SEARCH) {
				val text = binding.searchFieldHomeFragment.text.toString().trim()
				if (text.isNotEmpty()) {
					SearchedMovieActivity.newIntent(context,text)
					return@setOnEditorActionListener true
				}
			}
			return@setOnEditorActionListener false
		}
	}

	private fun imageCarousel(list: ArrayList<Carousel>) { // carousel image slider.
		val adapter = CarouselAdapter(context, list)
		val viewPager = binding.carouselImageSliderHomeFragment

		viewPager.clipToPadding = false
		viewPager.clipChildren = false
		viewPager.offscreenPageLimit = 3

		val compositePageTransform = CompositePageTransformer()
		compositePageTransform.addTransformer(MarginPageTransformer(20))
		compositePageTransform.addTransformer { page, position ->
			val r = 1 - abs(position)
			page.scaleY = 0.85f + r * 0.15f
		}
		viewPager.setPageTransformer(compositePageTransform)
		viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
		viewPager.adapter = adapter
		binding.dotsIndicatorInHomeFragment.attachTo(viewPager)
		viewPager.autoScroll(5000)
	}

	private val categoryMovieListener = object : Onclick {
		override fun onItemClickLister(item: Category) {
			CategoryMovieActivity.newIntent(context,item.name.toString())
		}
	}

	private fun initCategoryAdapter(list: ArrayList<Category>) {
		binding.tvCategoryHomeFragment.text = Util.capitalize("Categories")

		val adapter = CategoryMovieAdapter(list, categoryMovieListener)
		val rcView = binding.rcCategoryListHomeFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}

	private val popularMovieListener = object : OnMovieClick {
		override fun onItemClickListener(movie: MovieDetail) {
			val movieObject = Gson().toJson(movie)
			DetailMovieActivity.newIntent(context, movieObject)
		}
	}

	private fun initPopularMovieAdapter(list: ArrayList<MovieDetail>) {
		binding.tvPopularHomeFragment.text = Util.capitalize("Most Popular")

		val adapter = MovieAdapter(context, list, popularMovieListener)
		val rcView = binding.rcPopularListHomeFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}
}