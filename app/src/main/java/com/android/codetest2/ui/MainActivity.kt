package com.android.codetest2.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.codetest2.data.model.CategoriesItem
import com.android.codetest2.data.model.Response_GetCategory
import com.android.codetest2.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : ViewModelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
        attachObserve()
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(ViewModelMain::class.java)
        viewModel.getCategoryView()
    }

    private fun attachObserve(){
        viewModel.responseCat.observe(this, Observer { responseCat(it) })
        viewModel.isError.observe(this, Observer { isError(it) })
    }

    private fun responseCat(it: Response_GetCategory?) {
        binding.rvMainCat.adapter = AdapterCategory(this,it?.categories, object : AdapterCategory.onClick{
            override fun detail(item: CategoriesItem) {
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
    }

    private fun isError(it : Throwable){
        Log.d(TAG, it.localizedMessage ?: "")
    }
}