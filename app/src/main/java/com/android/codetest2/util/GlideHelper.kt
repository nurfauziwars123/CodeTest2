package com.android.codetest2.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


class GlideHelper {
    companion object {

        fun setImage(context: Context, urlImage: String, imageView: ImageView){
            Glide .with(context)
                .load(urlImage)
                .into(imageView)
        }
    }
}