package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
	private lateinit var binding: FragmentProfileBinding

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentProfileBinding.bind(view)

		// TODO: code here.
//		binding.tvText.text = "Profile Page"
	}
}