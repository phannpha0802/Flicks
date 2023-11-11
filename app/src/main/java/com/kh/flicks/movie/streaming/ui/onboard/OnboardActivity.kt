package com.kh.flicks.movie.streaming.ui.onboard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.adapters.OnboardAdapter
import com.kh.flicks.movie.streaming.databinding.ActivityOnboardBinding
import com.kh.flicks.movie.streaming.ui.auth.SignInActivity

class OnboardActivity : AppCompatActivity() {
	private lateinit var binding: ActivityOnboardBinding

	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_onboard)

		// TODO: code here.
		val adapter = OnboardAdapter(this)
		adapter.addFragment(
			OnboardV1Fragment(),
			getString(R.string.onboard_title_v1),
			getString(R.string.onboard_body_v1)
		)
		adapter.addFragment(
			OnboardV2Fragment(),
			getString(R.string.onboard_title_v2),
			getString(R.string.onboard_body_v2)
		)
		adapter.addFragment(
			OnboardV3Fragment(),
			getString(R.string.onboard_title_v3),
			getString(R.string.onboard_body_v3)
		)
		binding.onBoardViewPager2.adapter = adapter
		binding.dotsIndicatorOnboardScreen.attachTo(binding.onBoardViewPager2)

		// set title and body to the view when user swapped the page
		binding.onBoardViewPager2.registerOnPageChangeCallback(object :
			ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				super.onPageSelected(position)

				binding.titleOnboardScreen.text = adapter.getTitle(position)
				binding.bodyOnboardScreen.text = adapter.getBody(position)
			}
		})

		binding.btnNextOnboardScreen.setOnClickListener {
			// Get the current item of the ViewPager2
			val currentItem = binding.onBoardViewPager2.currentItem

			// If the current item is the last item, navigate to another screen
			if (currentItem == 2) {
				startActivity(Intent(this, SignInActivity::class.java))
				finish()
			} else {
				// Slide the ViewPager2 to the next item
				binding.onBoardViewPager2.currentItem = (currentItem + 1) % 3
			}
		}
	}
}