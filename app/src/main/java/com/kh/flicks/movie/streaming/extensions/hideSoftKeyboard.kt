package com.kh.flicks.movie.streaming.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun Activity.hideSoftKeyboard() {
	(getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
		hideSoftInputFromWindow(currentFocus?.windowToken, 0)
	}
}