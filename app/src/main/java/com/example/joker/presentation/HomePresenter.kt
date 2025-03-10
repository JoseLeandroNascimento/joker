package com.example.joker.presentation

import android.os.Handler
import android.os.Looper
import com.example.joker.model.Category
import com.example.joker.view.CategoryItem
import com.example.joker.view.HomeFragment

class HomePresenter(private val view:HomeFragment) {

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response:List<Category>){
        val categories = response.map {
            CategoryItem(it)
        }
        view.showCategories(categories)
    }

    fun onError(message:String){

    }

    fun onComplete(){
        view.hideProgress()
    }

    private fun fakeRequest() {

        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Category 1", 0xFFEB5A3C),
                Category("Category 2", 0xFFDF9755),
                Category("Category 3", 0xFFE7D283),
                Category("Category 4", 0xFFEDF4C2)
            )

            onSuccess(response)
            onComplete()

        }, 2000)
    }
}