package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
	private lateinit var binding: FragmentHomeBinding

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentHomeBinding.bind(view)

		// TODO: code here.
		binding.tvText.text = "Home Page"
	}
}