package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.CarouselAdapter
import com.kh.flicks.movie.streaming.adapters.CategoryAdapter
import com.kh.flicks.movie.streaming.adapters.PopularItemAdapter
import com.kh.flicks.movie.streaming.databinding.FragmentHomeBinding
import com.kh.flicks.movie.streaming.extensions.hideSoftKeyboard
import com.kh.flicks.movie.streaming.extensions.localImage
import com.kh.flicks.movie.streaming.extensions.autoScroll
import com.kh.flicks.movie.streaming.extensions.toastMessage
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Carousel
import com.kh.flicks.movie.streaming.networks.models.Category
import com.kh.flicks.movie.streaming.networks.models.MovieDetail
import com.kh.flicks.movie.streaming.ui.activities.ItemSearchedActivity
import com.kh.flicks.movie.streaming.utils.Util
import kotlin.math.abs

class HomeFragment(private val context: Activity) : Fragment(R.layout.fragment_home) {
	private lateinit var binding: FragmentHomeBinding

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentHomeBinding.bind(view)

		// TODO: code here.
		hideSoftKeyboardFromWindow()
		appBar()
		searchField()
		carouselImage()
		categoryList()
		popularList()
	}

	private fun hideSoftKeyboardFromWindow() {
		binding.mainContainerHomeFragment.setOnClickListener {
			context.hideSoftKeyboard()
		}
	}

	@SuppressLint("SetTextI18n")
	private fun appBar() {
		context.localImage(R.drawable.profile_image, binding.profileImageHomeFragment)
		binding.userNameHomeFragment.text = Util.capitalize("Hello, Davide!")
		binding.greetingTextHomeFragment.text = "Let's stream your favorite movies."
	}

	private fun searchField() {
		binding.searchFieldHomeFragment.setOnEditorActionListener { _, actionId, _ ->
			if (actionId == EditorInfo.IME_ACTION_SEARCH) {
				val text = binding.searchFieldHomeFragment.text.toString().trim()
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

	private fun carouselImage() {
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
		val adapter = CarouselAdapter(context, list)
		val viewPager = binding.carouselImageSliderHomeFragment

		viewPager.clipToPadding = false
		viewPager.clipChildren = false
		viewPager.offscreenPageLimit = 3

		val compositePageTransform = CompositePageTransformer()
		compositePageTransform.addTransformer(MarginPageTransformer(20))
		compositePageTransform.addTransformer { page, position ->
			// TODO: transform page here.
			val r = 1 - abs(position)
			page.scaleY = 0.85f + r * 0.15f
		}
		viewPager.setPageTransformer(compositePageTransform)
		viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
		viewPager.adapter = adapter
		binding.dotsIndicatorInHomeFragment.attachTo(viewPager)
		viewPager.autoScroll(5000)
	}

	private val categoryListener = object : Onclick {
		override fun onItemClickLister(item: Category) {
			// TODO: code here.
			context.toastMessage(item.name.toString())
		}
	}

	private fun categoryList() {
		binding.tvCategoryHomeFragment.text = Util.capitalize("Categories")
		val list = ArrayList<Category>()
		list.add(Category(1, "All"))
		list.add(Category(2, "Comedy"))
		list.add(Category(3, "Animation"))
		list.add(Category(4, "Document"))
		list.add(Category(5, "KDrama"))

		val adapter = CategoryAdapter(list, categoryListener)
		val rcView = binding.rcCategoryListHomeFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}

	private fun popularList() {
		binding.tvPopularHomeFragment.text = Util.capitalize("Most Popular")
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

		val adapter = PopularItemAdapter(context, list)
		val rcView = binding.rcPopularListHomeFragment
		rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
		rcView.adapter = adapter
	}
}