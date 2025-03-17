package com.example.joker.data

import android.os.Handler
import android.os.Looper

class CategoryRemoteDataSource {

    fun findAllCategories(callback:ListCategoryCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Category 1",
                "Category 2",
                "Category 3",
                "Category 4"
            )

            callback.onSuccess(response)
            callback.onComplete()

        }, 2000)
    }

}