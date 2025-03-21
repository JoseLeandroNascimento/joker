package com.example.joker.presentation

import com.example.joker.data.JokeRemoteDataSource
import com.example.joker.data.JokerCallback
import com.example.joker.model.Joke
import com.example.joker.view.JokerFragment


class JokePresenter(
    private val view: JokerFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokerCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoker(response)
        view.hideProgress()
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}