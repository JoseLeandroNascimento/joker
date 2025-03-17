package com.example.joker.presentation

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
        val categories = response.map {
            Category(it,0xFFFF0000)
        }
        view.showCategories(categories)
    }

    override fun onError(message:String){

    }

    override fun onComplete(){
        view.hideProgress()
    }


}