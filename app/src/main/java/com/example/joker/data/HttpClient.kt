package com.example.joker.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object HttpClient {

    private const val BASE_URL =
        "https://atway.tiagoaguiar.co/fenix/jokerapp/"

    const val API_KEY = "43c81700-f6da-4b67-8c08-1725e84fadf5"

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}