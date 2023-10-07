package com.kh.flicks.movie.streaming.ui.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.FragmentDownloadBinding

class DownloadFragment : Fragment(R.layout.fragment_download) {
	private lateinit var binding: FragmentDownloadBinding

	@SuppressLint("SetTextI18n")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentDownloadBinding.bind(view)

		// TODO: code here.
		binding.tvText.text = "Download Page"
	}
}