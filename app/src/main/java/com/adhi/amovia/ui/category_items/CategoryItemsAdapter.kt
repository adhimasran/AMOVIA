package com.adhi.amovia.ui.category_items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.databinding.ItemsGridBinding
import com.adhi.amovia.utils.Utility.loadImage

class CategoryItemsAdapter : RecyclerView.Adapter<CategoryItemsAdapter.FilmViewHolder>() {
    private val listFilm = ArrayList<FilmResponse>()

    fun setFilm(film: List<FilmResponse>) {
        listFilm.clear()
        listFilm.addAll(film)
        notifyDataSetChanged()
    }

    inner class FilmViewHolder(private val binding: ItemsGridBinding) :
    RecyclerView.ViewHolder(binding.root){
        fun bind(film: FilmResponse) {
            binding.apply {
                film.apply {
                    tvTitle.text = title ?: name
                    imgPoster.loadImage(posterPath)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemsGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = listFilm.size
}