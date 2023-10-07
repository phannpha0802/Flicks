package com.kh.flicks.movie.streaming.utils

import android.util.Log

object LogcatUtil {

	fun logcatMessage(tag: String, message: String) {
		Log.d(tag, "logcatMessage: $message")
	}

	fun logcatResponseData(tag: String, message: Any) {
		Log.d(tag, "Response data: $message")
	}
}