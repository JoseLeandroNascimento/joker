package com.example.joker.data

import com.example.joker.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRemoteDataSource {

    fun findBy(categoryName: String, callback: JokerCallback) {
        HttpClient.retrofit()
            .create(ChuckNorrisApi::class.java)
            .findBy(categoryName)
            .enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {

                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw RuntimeException("Joke não encontrado"))
                    } else {

                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }
}