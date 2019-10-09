package com.filmfy.app.ui.favourite

import com.filmfy.app.widget.RxBus
import com.filmfy.app.widget.RxEvent
import com.filmfy.domain.entitites.Film
import org.koin.core.KoinComponent
import org.koin.core.inject

class FavouritesPresenter(private var view: FavouritesContract.View?) : FavouritesContract.Presenter, KoinComponent{

    private val favouriteRepository: FavouritesContract.Model<Film> by inject()

    override fun getFilms() {
        if(favouriteRepository.getFavourites().isNotEmpty()) {
            view?.showFilms(favouriteRepository.getFavourites())
        }
    }

    override fun onItemSave(film: Film, isSave: Boolean, clickDetail: Boolean) {
        when {
            clickDetail -> view?.openDetail(film)
            isSave -> {
                favouriteRepository.addFavourite(film)
                updateFilm(film, isSave)
            }
            else -> {
                favouriteRepository.removeFavourites(film)
                updateFilm(film, isSave)
            }
        }
    }

    fun updateFilm(film: Film, isSave: Boolean){
        RxBus.publish(RxEvent.UpdateFilmFavourite(film, isSave))
    }

    override fun destroy() {
        view = null
    }
}