package com.filmfy.app.ui.favourite

import com.filmfy.app.base.BasePresenter
import com.filmfy.domain.entitites.Film

interface FavouritesContract {

    interface View{
        fun showFilms(film: ArrayList<Film>)
        fun openDetail(film: Film)
    }

    interface Presenter: BasePresenter {
        fun getFilms()
        fun onItemSave(film: Film, isSave: Boolean, clickDetail: Boolean)
    }

    interface Model<T>{
        fun addFavourite(film: Film)
        fun getFavourites(): ArrayList<Film>
        fun removeFavourites(film: Film)
    }
}