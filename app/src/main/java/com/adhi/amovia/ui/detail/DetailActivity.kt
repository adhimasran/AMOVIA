package com.adhi.amovia.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adhi.amovia.R
import com.adhi.amovia.data.source.remote.response.DetailFilmResponse
import com.adhi.amovia.databinding.ActivityDetailBinding
import com.adhi.amovia.utils.Utility.convertToDate
import com.adhi.amovia.utils.Utility.convertToTime
import com.adhi.amovia.utils.Utility.loadImage

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaType = intent.getStringExtra(EXTRA_MEDIA)
        val id = intent.getIntExtra(EXTRA_ID, 0)
    }

    private fun setDetail(film: DetailFilmResponse) {
        var movieYear: String? = null
        var tvYear: String? = null
        if (film.release != null) {
            movieYear =
                film.release.convertToDate().split(", ")[1]
        }

        if (film.firstAir != null) {
            tvYear = film.firstAir.convertToDate().split(", ")[1]
        }

        val tvRuntime =
            if (film.episodeRuntime.isNotEmpty()) film.episodeRuntime.first() else 0

        binding.apply {
            film.apply {
                imgBackdrop.loadImage(backdropPath)
                imgPoster.loadImage(posterPath)
                tvTitle.text = resources.getString(
                    R.string.title,
                    title ?: name,
                    movieYear ?: tvYear
                )
                tvTagline.text = tagline
                tvRating.text = resources.getString(R.string.rating, rating.toString())
                tvRatingCount.text = resources.getString(
                    R.string.rating_count,
                    ratingCount.toString()
                )
                tvRelease.text = release?.convertToDate() ?: firstAir?.convertToDate()
                tvDuration.text =
                    if (episodeRuntime.isNotEmpty()) tvRuntime.convertToTime() else runtime.convertToTime()
                tvOverview.text = overview
            }
        }
    }

    companion object {
        const val EXTRA_MEDIA = "extra_media"
        const val EXTRA_ID = "extra_id"
    }
}