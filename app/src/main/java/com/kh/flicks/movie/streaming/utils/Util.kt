package com.kh.flicks.movie.streaming.utils

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.Locale

object Util {

	// ex: capitalize me => Capitalize Me.
	fun capitalize(str: String): String {
		return str.trim().split("\\s+".toRegex()).joinToString(" ") { it.capitalize(Locale.ROOT) }
	}
}