package com.example.joker.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback) {
        HttpClient.retrofit()
            .create(ChuckNorrisApi::class.java)
            .finAllCategories(HttpClient.API_KEY)
            .enqueue(object : Callback<List<String>>{

                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {

                    if(response.isSuccessful){
                        val obj = response.body()
                        callback.onSuccess(obj ?: emptyList())
                        callback.onComplete()
                    }else{
                        val error = response.errorBody()?.toString()
                        callback.onError(error ?: "Erro desconhecido")
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Error Interno")
                    callback.onComplete()
                }

            })
            
    }

}