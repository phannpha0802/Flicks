package com.kh.flicks.movie.streaming.utils

import java.util.Locale

object Util {

	// ex: capitalize me => Capitalize Me.
	fun capitalize(str: String): String {
		return str.trim().split("\\s+".toRegex()).joinToString(" ") { it.capitalize(Locale.ROOT) }
	}
}