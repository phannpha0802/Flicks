package com.kh.flicks.movie.streaming.extensions

import android.app.Activity
import android.widget.Toast

fun Activity.toastMessage(message: String) {
	Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}