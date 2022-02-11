package com.adhi.amovia.ui.category_items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.adhi.amovia.databinding.ActivityCategoryItemsBinding

class CategoryItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryItemsBinding
    private val categoryItemsAdapter = CategoryItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaType = intent.getStringExtra(EXTRA_MEDIA)
        val category = intent.getStringExtra(EXTRA_CATEGORY)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvFilm.apply {
            adapter = categoryItemsAdapter
            layoutManager = GridLayoutManager(this@CategoryItemsActivity, 2)
        }
    }

    companion object {
        const val EXTRA_MEDIA = "extra_media"
        const val EXTRA_CATEGORY = "extra_category"
    }
}