package com.android.codetest2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.codetest2.R
import com.android.codetest2.data.model.CategoriesItem
import com.android.codetest2.util.GlideHelper

class AdapterCategory(val context : Context, val data : List<CategoriesItem>?, val itemClick : onClick) : RecyclerView.Adapter<AdapterCategory.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.iv_item)
        val title = view.findViewById<TextView>(R.id.tv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCategory.ViewHolder {
      val view = LayoutInflater.from(context).inflate(R.layout.item_category, null, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AdapterCategory.ViewHolder, position: Int) {
        val item = data?.get(position)
        GlideHelper.setImage(context, item?.strCategoryThumb ?: "", holder.image)
        holder.title.setText(item?.strCategory)

        holder.itemView.setOnClickListener {
            item?.let { item -> itemClick.detail(item) }
        }
    }

    interface onClick{
        fun detail(item : CategoriesItem)
    }
}