package com.adhi.amovia.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.databinding.ItemsListHomeBinding
import com.adhi.amovia.utils.Utility.loadImage

class OnAirTvAdapter : RecyclerView.Adapter<OnAirTvAdapter.TvViewHolder>() {
    private val listTv = ArrayList<FilmResponse>()

    fun setData(tv: List<FilmResponse>) {
        listTv.clear()
        listTv.addAll(tv)
        notifyDataSetChanged()
    }

    inner class TvViewHolder(private val binding: ItemsListHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onAirTv: FilmResponse) {
            binding.apply {
                onAirTv.apply {
                    tvTitle.text = name
                    tvRating.text = rating.toString()
                    imgPoster.loadImage(posterPath)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnAirTvAdapter.TvViewHolder {
        val binding =
            ItemsListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = listTv[position]
        holder.bind(tv)
    }

    override fun getItemCount(): Int = listTv.size

}