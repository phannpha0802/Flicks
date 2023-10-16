package com.kh.flicks.movie.streaming.networks.models

import android.os.Parcel
import android.os.Parcelable

data class MovieDetail(
	var id: Int?,
	var title: String?,
	var image: Int?,
	var desc: String?,
	var releaseDate: String?,
	var rating: Double?,
	var category: String?
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Double::class.java.classLoader) as? Double,
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(id)
		parcel.writeString(title)
		parcel.writeValue(image)
		parcel.writeString(desc)
		parcel.writeString(releaseDate)
		parcel.writeValue(rating)
		parcel.writeString(category)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<MovieDetail> {
		override fun createFromParcel(parcel: Parcel): MovieDetail {
			return MovieDetail(parcel)
		}

		override fun newArray(size: Int): Array<MovieDetail?> {
			return arrayOfNulls(size)
		}
	}
}
