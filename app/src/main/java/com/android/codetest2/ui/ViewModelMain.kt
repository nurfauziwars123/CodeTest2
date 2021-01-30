package com.android.codetest2.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.codetest2.data.model.Response_GetCategory
import com.android.codetest2.remote.Repository
import okhttp3.Response

class ViewModelMain : ViewModel() {

    private val repository = Repository()
    val responseCat = MutableLiveData<Response_GetCategory>()
    val isError = MutableLiveData<Throwable>()

    fun getCategoryView(){
        repository.getCategory({
            responseCat.value = it
        },{
            isError.value = it
        })
    }
}