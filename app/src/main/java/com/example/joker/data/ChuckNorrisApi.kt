package com.example.joker.data

import com.example.joker.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun finAllCategories(@Query("apiKey") apiKey: String): Call<List<String>>

    @GET("jokes/random")
    fun findRandom(
        @Query("category") categoryName: String? = null,
        @Query("apiKey") apiKey: String = HttpClient.API_KEY
    ): Call<Joke>
}