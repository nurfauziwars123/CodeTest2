package com.android.codetest2.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.codetest2.R
import com.android.codetest2.data.model.CategoriesItem
import com.android.codetest2.databinding.ActivityDetailBinding
import com.android.codetest2.util.GlideHelper
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
    }

    private fun initView() {
        val data = intent.getParcelableExtra<CategoriesItem>("data")

        data.let {
            GlideHelper.setImage(this, data?.strCategoryThumb ?: "", binding.ivDetail)
            tv_Detail_title.setText(data?.strCategory)
        }
    }
}