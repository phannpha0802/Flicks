package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.CategoryAdapter
import com.kh.flicks.movie.streaming.databinding.FragmentSearchBinding
import com.kh.flicks.movie.streaming.extensions.toastMessage
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.ui.activities.ItemSearchedActivity

class SearchFragment(private val context: Activity) : Fragment(R.layout.fragment_search) {
	private lateinit var binding: FragmentSearchBinding

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentSearchBinding.bind(view)

		// TODO: code here.
		searchField()
		categoryList()
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
			// TODO: code here.
			context.toastMessage(item.name.toString())
		}
	}

	private fun categoryList() {
		val list = ArrayList<Category>()
		list.add(Category(1, "All"))
		list.add(Category(2, "Comedy"))
		list.add(Category(3, "Animation"))
		list.add(Category(4, "Document"))
		list.add(Category(5, "KDrama"))

		val adapter = CategoryAdapter(list, categoryListener)
		val rcView = binding.rcCategoryListSearchFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}
}