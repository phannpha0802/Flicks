package com.kh.flicks.movie.streaming.extensions

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Activity.networkImage(url: String, view: ImageView) {
    Glide.with(this).load(url).into(view)
}