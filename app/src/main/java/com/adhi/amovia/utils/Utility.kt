package com.adhi.amovia.utils

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.getColor
import com.adhi.amovia.R
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
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

    fun ChipGroup.addChip(context: Context, label: String) {
        Chip(context).apply {
            id = View.generateViewId()
            text = label
            isCheckable = false
            isClickable = false
            isFocusable = false
            chipBackgroundColor =
                ColorStateList.valueOf(getColor(context, R.color.gold))
            addView(this)
        }
    }
}