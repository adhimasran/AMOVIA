package com.adhi.amovia.ui.category_items

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.adhi.amovia.databinding.ActivityCategoryItemsBinding

class CategoryItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryItemsBinding
    private val categoryItemsAdapter = CategoryItemsAdapter()
    private val viewModel by viewModels<CategoryItemsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val mediaType = intent.getStringExtra(EXTRA_MEDIA)
        val category = intent.getStringExtra(EXTRA_CATEGORY)

        if (mediaType != null && category != null) {
            viewModel.getCategoryItems(mediaType, category).observe(this, {
                categoryItemsAdapter.setFilm(it)
            })
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvFilm.apply {
            adapter = categoryItemsAdapter
            layoutManager = GridLayoutManager(this@CategoryItemsActivity, 2)
        }
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_MEDIA = "extra_media"
        const val EXTRA_CATEGORY = "extra_category"
    }
}