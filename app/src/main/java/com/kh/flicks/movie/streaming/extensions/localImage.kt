package com.kh.flicks.movie.streaming.extensions

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Activity.localImage(url: Int, view: ImageView) {
	Glide.with(this).load(url).into(view)
}