package com.filmfy.app.ui.search

import android.util.Log
import com.filmfy.di.rx.SchedulerProvider
import com.filmfy.data.network.RetrofitAdapter
import com.filmfy.domain.entitites.Film
import com.filmfy.domain.interactor.AbstractInteractor

class SearchImpl : AbstractInteractor() {

    private val voucherApiServe by lazy {
        RetrofitAdapter.create()
    }

    fun getfilms(genre: String, rating: String, pagination: String, limit: String, callback: SearchContract.Callback?, schedule: SchedulerProvider){
        disposable = voucherApiServe.getFilms() // mock json call if can't run docker
//        disposable = voucherApiServe.getFilms(genre, rating, pagination, limit)
            .subscribeOn(schedule.io())
            .observeOn(schedule.ui())
            .subscribe(
                { result -> processFilmSearch(result.data, callback)},
                { error -> processError(error, callback) }
            )
    }

    fun destroy() {
        clearComposite()
    }

    fun processFilmSearch(filmList : ArrayList<Film>?, callback: SearchContract.Callback?){
        callback?.onResponseSearchFilm(filmList)
    }
    private fun processError(error: Throwable, callback: SearchContract.Callback?){
        callback?.onError()
        Log.e("Search", error.toString())
    }
}