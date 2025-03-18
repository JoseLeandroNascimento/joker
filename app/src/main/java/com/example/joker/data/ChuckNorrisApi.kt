package com.example.joker.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun finAllCategories(@Query("apiKey") apiKey:String):Call<List<String>>
}