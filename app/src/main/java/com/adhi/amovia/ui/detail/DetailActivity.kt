package com.adhi.amovia.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhi.amovia.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object {
        const val EXTRA_MEDIA = "extra_media"
        const val EXTRA_ID = "extra_id"
    }
}