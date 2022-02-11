package com.adhi.amovia.ui.category_items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adhi.amovia.databinding.ActivityCategoryItemsBinding

class CategoryItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val EXTRA_MEDIA = "extra_category"
        const val EXTRA_CATEGORY= "extra_category"
    }
}