package com.filmfy.app.ui.search

import android.util.Log
import com.filmfy.data.network.RetrofitAdapter
import com.filmfy.domain.entitites.FilmRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import com.filmfy.domain.interactor.AbstractInteractor

class SearchImpl : AbstractInteractor() {

    private val voucherApiServe by lazy {
        RetrofitAdapter.create()
    }

    fun getfilms(genre: String, rating: String, pagination: String, limit: String, callback: SearchContract.Callback?){
        disposable = voucherApiServe.getFilms() // mock json call if can't run docker
//        disposable = voucherApiServe.getFilms(genre, rating, pagination, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> processFilmSearch(result, callback)},
                { error -> processError(error) }
            )
    }

    fun destroy() {
        clearComposite()
    }

    private fun processFilmSearch(result : Response<FilmRequest>, callback: SearchContract.Callback?){
        callback?.onResponseSearchFilm(result.body()?.data)
    }
    private fun processError(error: Throwable){
        Log.e("Search", error.toString())
    }
}