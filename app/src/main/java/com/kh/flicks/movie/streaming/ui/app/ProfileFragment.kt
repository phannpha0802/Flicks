package com.kh.flicks.movie.streaming.ui.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
	private lateinit var binding: FragmentProfileBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentProfileBinding.bind(view)
	}
}