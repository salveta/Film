package com.filmfy.app.ui.filmDetail

import com.filmfy.domain.entitites.Film
import org.koin.core.KoinComponent


class FilmDetailPresenter(private var view: FilmDetailContract.View?): FilmDetailContract.Presenter, KoinComponent{

    override fun handleIntentData(film: Film?) {
        if(film != null) {
            view!!.showData(film)
        }else{
            view!!.errorDisplayingDetail()
        }
    }

    override fun destroy() {
        view = null
    }
}