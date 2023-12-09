package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.CategoryMovieAdapter
import com.kh.flicks.movie.streaming.adapters.MovieAdapter
import com.kh.flicks.movie.streaming.adapters.MovieTodayAdapter
import com.kh.flicks.movie.streaming.databinding.FragmentSearchBinding
import com.kh.flicks.movie.streaming.listeners.OnMovieClick
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.ui.activities.CategoryMovieActivity
import com.kh.flicks.movie.streaming.ui.activities.DetailMovieActivity
import com.kh.flicks.movie.streaming.ui.activities.SearchedMovieActivity
import com.kh.flicks.movie.streaming.utils.Util
import com.kh.flicks.movie.streaming.vm.SearchViewModel
import kotlinx.coroutines.launch

class SearchFragment(private val context: Activity) : Fragment(R.layout.fragment_search) {
	private lateinit var binding: FragmentSearchBinding
	private lateinit var searchViewModel: SearchViewModel

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentSearchBinding.bind(view)
		initObject()
		observeViewModel()
	}

	private fun initObject(){ // init all object here.
		searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
		searchField()
	}

	private fun observeViewModel(){ // observe view model
		lifecycleScope.launch {
			searchViewModel.uiState.observe(viewLifecycleOwner) { item ->
				// assign data.
				categoryList(item.category)
				initMovieTodayAdapter(item.itemToday)
				initMovieRecommendAdapter(item.itemRecommend)
			}
		}
	}

	private fun searchField() {  // search field.
		binding.searchField.setOnEditorActionListener { _, actionId, _ ->
			if (actionId == EditorInfo.IME_ACTION_SEARCH) {
				val text = binding.searchField.text.toString().trim()
				if (text.isNotEmpty()) {
					context.startActivity(Intent(context, SearchedMovieActivity::class.java).apply {
						putExtra("data", text)
					})
					return@setOnEditorActionListener true
				}
			}
			return@setOnEditorActionListener false
		}
	}

	private val categoryMovieListener = object : Onclick {
		override fun onItemClickLister(item: Category) {
			CategoryMovieActivity.newIntent(context,item.name)
		}
	}

	private fun categoryList(list: ArrayList<Category>) {
		val adapter = CategoryMovieAdapter(list, categoryMovieListener)
		val rcView = binding.rcCategoryListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}

	private fun initMovieTodayAdapter(list: ArrayList<MovieDetail>) {
		binding.tvTodaySearchFragment.text = Util.capitalize("Today")
		val adapter = MovieTodayAdapter(context, list)
		val rcView = binding.rcTodayListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
		rcView.adapter = adapter
	}

	private val movieListener = object : OnMovieClick {
		override fun onItemClickListener(movie: MovieDetail) {
			val movieObject = Gson().toJson(movie)
			DetailMovieActivity.newIntent(context, movieObject)
		}
	}

	private fun initMovieRecommendAdapter(list: ArrayList<MovieDetail>) {
		binding.tvRecommendSearchFragment.text = Util.capitalize("Recommend for you")
		val adapter = MovieAdapter(context, list, movieListener)
		val rcView = binding.rcRecommendListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}
}