package com.filmfy.data.repository

import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.data.database.film.FilmDatabase
import com.filmfy.domain.entitites.Film
import org.koin.core.KoinComponent
import org.koin.core.inject

object FavouriteRepository: FavouritesContract.Model<Film>, KoinComponent{

    private val database: FilmDatabase by inject()

    override fun getFavourites(): ArrayList<Film>{
        return ArrayList(database.filmDao().loadAllFilms())
    }

    override fun addFavourite(film: Film) {
        database.filmDao().insertFilm(film)
    }

    override fun removeFavourites(film: Film) {
        database.filmDao().deleteFilm(film)
    }
}
