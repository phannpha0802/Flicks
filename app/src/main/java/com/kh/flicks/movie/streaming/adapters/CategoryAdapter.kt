package com.kh.flicks.movie.streaming.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kh.flicks.movie.streaming.R
import com.kh.flicks.movie.streaming.databinding.ItemCategoryLayoutBinding
import com.kh.flicks.movie.streaming.listeners.Onclick
import com.kh.flicks.movie.streaming.networks.models.Category

class CategoryAdapter(private val category: ArrayList<Category>, private val onClick: Onclick) :
	RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

	private var currentPosition = 0

	inner class ViewHolder(private val binding: ItemCategoryLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {
		@SuppressLint("NotifyDataSetChanged")
		fun onBind(item: Category, position: Int) {
			binding.nameCategory.text = item.name
			binding.root.setOnClickListener {
				onClick.onItemClickLister(item)
				currentPosition = position
				notifyDataSetChanged()
			}
			if (currentPosition == position) {
				binding.categoryLayout.background =
					ContextCompat.getDrawable(
						binding.root.context,
						R.drawable.category_bg
					)
				binding.nameCategory.setTextColor(
					ContextCompat.getColor(
						binding.root.context,
						R.color.blue_accent_color
					)
				)
			} else {
				binding.categoryLayout.background = null
				binding.nameCategory.setTextColor(
					ContextCompat.getColor(
						binding.root.context,
						R.color.white_grey_color
					)
				)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding: ItemCategoryLayoutBinding =
			DataBindingUtil.inflate(
				LayoutInflater.from(parent.context),
				R.layout.item_category_layout,
				parent,
				false
			)
		return ViewHolder(binding)
	}

	override fun getItemCount(): Int = category.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(category[position], position)
	}
}