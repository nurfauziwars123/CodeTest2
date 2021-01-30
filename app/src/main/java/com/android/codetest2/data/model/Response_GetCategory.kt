package com.android.codetest2.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response_GetCategory(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null
) : Parcelable

@Parcelize
data class CategoriesItem(

	@field:SerializedName("strCategory")
	val strCategory: String? = null,

	@field:SerializedName("strCategoryDescription")
	val strCategoryDescription: String? = null,

	@field:SerializedName("idCategory")
	val idCategory: String? = null,

	@field:SerializedName("strCategoryThumb")
	val strCategoryThumb: String? = null
) : Parcelable
