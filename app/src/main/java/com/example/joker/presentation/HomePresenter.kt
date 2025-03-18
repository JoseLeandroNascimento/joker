package com.example.joker.presentation

import android.graphics.Color
import com.example.joker.data.CategoryRemoteDataSource
import com.example.joker.data.ListCategoryCallback
import com.example.joker.model.Category
import com.example.joker.view.HomeFragment

class HomePresenter(
    private val view:HomeFragment,
    private val dataSource: CategoryRemoteDataSource
    ) : ListCategoryCallback{

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start)/response.size

        val categories = response.mapIndexed { index,s->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )
            Category( s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onError(message:String){



    }

    override fun onComplete(){
        view.hideProgress()
    }


}