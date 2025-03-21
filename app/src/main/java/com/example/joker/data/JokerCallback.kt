package com.example.joker.data

import com.example.joker.model.Joke

interface JokerCallback {

    fun onSuccess(response:Joke);

    fun onError(response:String);

    fun onComplete();
}