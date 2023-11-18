package com.kh.flicks.movie.streaming.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardAdapter(fragmentActivity: FragmentActivity) :
	FragmentStateAdapter(fragmentActivity) {

	private val fragmentList = mutableListOf<Fragment>()
	private val titleList = mutableListOf<String>()
	private val bodyList = mutableListOf<String>()

	fun addFragment(fragment: Fragment, title: String, body: String) {
		fragmentList.add(fragment)
		titleList.add(title)
		bodyList.add(body)
	}

	fun getTitle(position: Int): CharSequence = titleList[position]

	fun getBody(position: Int): CharSequence = bodyList[position]

	override fun getItemCount(): Int = fragmentList.size

	override fun createFragment(position: Int): Fragment = fragmentList[position]
}