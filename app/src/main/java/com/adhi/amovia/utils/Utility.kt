package com.adhi.amovia.utils

import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utility {
    fun ImageView.loadImage(path: String) {
        Glide.with(context)
            .load("${Constants.BASE_URL_IMG}${path}")
            .into(this)
    }

    fun Int.convertToTime(): String {
        return "${if (this / 60 > 0) "${this / 60}h " else ""}${this % 60}m"
    }

    fun String.convertToDate(): String {
        val format = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
        val date = LocalDate.parse(this)
        return date.format(format)
    }
}