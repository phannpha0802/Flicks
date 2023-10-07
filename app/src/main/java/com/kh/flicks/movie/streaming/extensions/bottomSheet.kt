package com.kh.flicks.movie.streaming.extensions

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun Activity.showBottomSheet(view: View, context: BottomSheetDialogFragment) {
    view.setOnClickListener {
        context.show(
            (this as AppCompatActivity).supportFragmentManager,
            "show pop up"
        )
    }
}