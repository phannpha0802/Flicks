package com.kh.flicks.movie.streaming.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ActivityItemCategoryBinding
import com.kh.flicks.movie.streaming.extensions.toastMessage

class ItemCategoryActivity : AppCompatActivity() {
	private lateinit var binding: ActivityItemCategoryBinding

	companion object {
		fun newIntent(activity: Activity?, data: String?){
			activity?.startActivity(Intent(activity, ItemCategoryActivity::class.java).apply {
				putExtra("data", data)
			})
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_item_category)
		initObject()
	}

	private fun initObject(){
		val bundle: Bundle? = intent.extras
		val category = bundle?.getString("data").toString()
		toastMessage(category)
	}
}