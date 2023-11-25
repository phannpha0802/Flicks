package com.kh.flicks.movie.streaming

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kh.flicks.movie.streaming.databinding.ActivityMainBinding
import com.kh.flicks.movie.streaming.ui.activities.ItemDetailActivity
import com.kh.flicks.movie.streaming.ui.app.DownloadFragment
import com.kh.flicks.movie.streaming.ui.app.HomeFragment
import com.kh.flicks.movie.streaming.ui.app.ProfileFragment
import com.kh.flicks.movie.streaming.ui.app.SearchFragment

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	companion object {
		fun newIntent(activity: Activity?) {
			activity?.startActivity(Intent(activity, MainActivity::class.java))
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
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