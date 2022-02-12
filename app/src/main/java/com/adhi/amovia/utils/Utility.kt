package com.adhi.amovia.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object Utility {
    fun ImageView.loadImage(path: String) {
        Glide.with(context)
            .load("${Constants.BASE_URL_IMG}${path}")
            .into(this)
    }

    fun Int.convertToTime(): String {
        return "${if (this / 60 > 0) "${this / 60}h " else ""}${this % 60}m"
    }
}