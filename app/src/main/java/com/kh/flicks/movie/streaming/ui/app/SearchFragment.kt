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
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.CategoryAdapter
import com.kh.flicks.movie.streaming.adapters.MovieAdapter
import com.kh.flicks.movie.streaming.adapters.MovieTodayAdapter
import com.kh.flicks.movie.streaming.databinding.FragmentSearchBinding
import com.kh.flicks.movie.streaming.listeners.OnMovieClick
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.ui.activities.ItemCategoryActivity
import com.kh.flicks.movie.streaming.ui.activities.ItemDetailActivity
import com.kh.flicks.movie.streaming.ui.activities.ItemSearchedActivity
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
		searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

		searchField()
		lifecycleScope.launch {
			searchViewModel.uiState.observe(viewLifecycleOwner) { item ->
				// assign data.
				categoryList(item.category)
				todayList(item.itemToday)
				recommendList(item.itemRecommend)
			}
		}
	}

	private fun searchField() {
		binding.searchField.setOnEditorActionListener { _, actionId, _ ->
			if (actionId == EditorInfo.IME_ACTION_SEARCH) {
				val text = binding.searchField.text.toString().trim()
				if (text.isNotEmpty()) {
					context.startActivity(Intent(context, ItemSearchedActivity::class.java).apply {
						putExtra("data", text)
					})
					return@setOnEditorActionListener true
				}
			}
			return@setOnEditorActionListener false
		}
	}

	private val categoryListener = object : Onclick {
		override fun onItemClickLister(item: Category) {
			// TODO: navigate to ItemCategoryActivity.
			context.startActivity(Intent(context, ItemCategoryActivity::class.java).apply {
				putExtra("data", item.name.toString())
			})
		}
	}

	private fun categoryList(list: ArrayList<Category>) {

		val adapter = CategoryAdapter(list, categoryListener)
		val rcView = binding.rcCategoryListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}

	private fun todayList(list: ArrayList<MovieDetail>) {
		binding.tvTodaySearchFragment.text = Util.capitalize("Today")
		val adapter = MovieTodayAdapter(context, list)
		val rcView = binding.rcTodayListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
		rcView.adapter = adapter
	}

	private val movieListener = object : OnMovieClick {
		override fun onItemClickListener(movie: MovieDetail) {
			ItemDetailActivity.newIntent(context,movie.toString())
		}
	}

	private fun recommendList(list: ArrayList<MovieDetail>) {
		binding.tvRecommendSearchFragment.text = Util.capitalize("Recommend for you")
		val adapter = MovieAdapter(context, list, movieListener)
		val rcView = binding.rcRecommendListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}
}