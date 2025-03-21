package com.example.joker.presentation

import com.example.joker.data.JokeDayRemoteDataSource
import com.example.joker.data.JokerCallback
import com.example.joker.model.Joke
import com.example.joker.view.JokeDayFragment

class JokeDayPresenter (
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
): JokerCallback {

    fun findRandom() {
        view.showProgress()
        dataSource.findRandom(this)
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