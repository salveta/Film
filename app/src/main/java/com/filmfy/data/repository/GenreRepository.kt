package com.filmfy.data.repository

import com.filmfy.app.ui.search.SearchContract
import com.filmfy.domain.entitites.Film
import org.koin.core.KoinComponent


object GenreRepository: SearchContract.Model<Film>, KoinComponent {

    private var genreFilm = HashMap<String, ArrayList<Film>>()

    override fun addFilms(genre: String, film: ArrayList<Film>) {
        genreFilm[genre] = film
    }

    override fun getFilms(genre: String): ArrayList<Film>?{
        return genreFilm[genre]
    }

    override fun clearFilms() {
        genreFilm.clear()
    }
}
