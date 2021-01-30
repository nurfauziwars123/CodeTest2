package com.android.codetest2.remote

import android.util.Log
import com.android.codetest2.data.model.Response_GetCategory
import com.android.codetest2.data.service.NetworkConf
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.xml.sax.ErrorHandler
import java.util.logging.Handler

private const val TAG = "Repository"
class Repository {

    fun getCategory(responseHandler: (Response_GetCategory) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkConf.service().getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}