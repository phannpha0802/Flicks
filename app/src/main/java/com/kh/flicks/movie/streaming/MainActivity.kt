package com.kh.flicks.movie.streaming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.databinding.ActivityMainBinding
import com.kh.flicks.movie.streaming.ui.app.DownloadFragment
import com.kh.flicks.movie.streaming.ui.app.HomeFragment
import com.kh.flicks.movie.streaming.ui.app.ProfileFragment
import com.kh.flicks.movie.streaming.ui.app.SearchFragment

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

		// TODO: code here.
		bottomNavigationBarItemSelected()
	}

	private fun bottomNavigationBarItemSelected() {
		//default screen
		val homeFragment = HomeFragment(this@MainActivity)
		setFragment(homeFragment)

		binding.bottomNavigationBarMainActivity.onItemSelected = {
			when (it) {
				0 -> {
					setFragment(homeFragment)
				}

				1 -> {
					setFragment(SearchFragment(this@MainActivity))
				}

				2 -> {
					setFragment(DownloadFragment())
				}

				3 -> {
					setFragment(ProfileFragment())
				}
			}
		}
	}

	// create function to refresh fragment
	private fun setFragment(fragment: Fragment) {
		supportFragmentManager.beginTransaction().apply {
			replace(R.id.fragmentContainerViewMainActivity, fragment)
			commitNow()
		}
	}
}