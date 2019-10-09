package com.filmfy.app.ui.filmDetail

import com.filmfy.app.base.BasePresenter
import com.filmfy.domain.entitites.Film

interface FilmDetailContract {

    interface View {
        fun showData(film: Film?)
        fun errorDisplayingDetail()
    }

    interface Presenter: BasePresenter {
        fun handleIntentData(film: Film?)
    }
}