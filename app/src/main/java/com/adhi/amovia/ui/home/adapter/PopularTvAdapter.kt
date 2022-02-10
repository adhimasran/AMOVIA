package com.adhi.amovia.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.databinding.ItemsListHomeLargeBinding
import com.adhi.amovia.utils.Utility.loadImage

class PopularTvAdapter : RecyclerView.Adapter<PopularTvAdapter.TvViewHolder>() {
    private val listTv = ArrayList<FilmResponse>()

    fun setTv(tv: List<FilmResponse>) {
        listTv.clear()
        listTv.addAll(tv)
        notifyDataSetChanged()
    }

    inner class TvViewHolder(private val binding: ItemsListHomeLargeBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(popularTv: FilmResponse) {
                    binding.apply {
                        popularTv.apply {
                            tvTitle.text = name
                            imgPoster.loadImage(backdropPath ?: posterPath)
                        }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val binding = ItemsListHomeLargeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = listTv[position]
        holder.bind(tv)
    }

    override fun getItemCount(): Int = listTv.size
}