package com.android.codetest2.data.service

import com.android.codetest2.data.model.Response_GetCategory
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface Service {

    @GET("1/categories.php")
    fun getList() : Flowable<Response_GetCategory>
}