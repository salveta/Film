package com.filmfy.app.ui.search

import androidx.annotation.Nullable
import com.filmfy.app.base.BasePresenter
import com.filmfy.app.idlingResource.SimpleIdlingResource
import com.filmfy.domain.entitites.Film


interface SearchContract {

    interface View{
        fun genreSearchError()
        fun showFilms(film: ArrayList<Film>, media: Double)
        fun doVisibleFilmItems()
        fun resetFilms()
        fun openDetail(film: Film)
    }

    interface Presenter: BasePresenter {
        fun doSearch(textToSearch: String, gettingNewGenre: Boolean, @Nullable idlingResource: SimpleIdlingResource?)
        fun onItemSave(film: Film, isSave: Boolean, clickDetail: Boolean)
        fun getFirstGenreInSearch(genre: String): String
        fun checkIfDataExistInMemory(textToSearch: String, pagination: Int, limit: Int)
        fun calculateMedia(film: ArrayList<Film>?)
        fun doSearchForTesting(textToSearch: String, genres: List<String>)
        fun getMedia(medianList: List<Double>): Double
        fun sumPagination()
        fun resetPagination()
    }

    interface Callback {
        fun onResponseSearchFilm(film: ArrayList<Film>?)
        fun onError()
    }

    interface Model<T> {
        fun addFilms(genre: String, film: ArrayList<T>)
        fun getFilms(genre: String): ArrayList<T>?
        fun clearFilms()
    }
}