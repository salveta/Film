package com.filmfy.app.ui.search

import androidx.annotation.Nullable
import org.koin.core.KoinComponent
import com.filmfy.ApplicationConfig
import com.filmfy.R
import com.filmfy.di.rx.SchedulerProvider
import com.filmfy.app.idlingResource.SimpleIdlingResource
import com.filmfy.app.idlingResource.decrementIdlingResource
import com.filmfy.app.idlingResource.incrementIdlingResource
import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.domain.entitites.Film
import org.koin.core.inject

const val SCIENCE_FICTION = "SCIENCE FICTION"
const val SCIENCE = "SCIENCE"
const val LIMIT = 20

class SearchPresenter(private var view: SearchContract.View?, private var mSearchImpl : SearchImpl, var scheduler: SchedulerProvider) : SearchContract.Presenter, KoinComponent, SearchContract.Callback  {

    private val genreRepository: SearchContract.Model<Film> by inject()
    private val favouriteRepository: FavouritesContract.Model<Film> by inject()

    private val numbers = mutableListOf<Double>()
    private var searchGenre: String = ""
    private var cleanFilms: Boolean = false
    @Nullable
    var mIdlingResource: SimpleIdlingResource? = null

    private var pagination: Int = 0

    override fun destroy() {
        view = null
        mSearchImpl.destroy()
    }

    override fun sumPagination() {
        this.pagination = pagination.plus(1)
    }

    override fun resetPagination() {
        this.pagination = 0
    }

    override fun doSearch(textToSearch: String, gettingNewGenre: Boolean, @Nullable idlingResource: SimpleIdlingResource?) {
        if(searchGenre(getFirstGenreInSearch(textToSearch))) {
            this.mIdlingResource = idlingResource
            this.cleanFilms = gettingNewGenre
            this.searchGenre = textToSearch
            checkIfDataExistInMemory(textToSearch, pagination, LIMIT)
        }else{
            view?.genreSearchError()
        }
    }

    override fun checkIfDataExistInMemory(textToSearch: String, pagination: Int, limit: Int){
        incrementIdlingResource(mIdlingResource)

        if(pagination == 0 && !genreRepository.getFilms(searchGenre).isNullOrEmpty()){
            onResponseSearchFilm(genreRepository.getFilms(searchGenre))
        }else{
            mSearchImpl.getfilms(textToSearch.capitalizeWords(), "5", pagination.toString(), limit.toString(), this, scheduler)
        }
    }

    private fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

    override fun onResponseSearchFilm(film: ArrayList<Film>?) {
        genreRepository.addFilms(searchGenre, film!!)
        calculateMedia(film)
    }

    override fun calculateMedia(film: ArrayList<Film>?){
        film?.let {
            for(value in film){
                numbers.add(value.rating)
            }
        }

        view?.doVisibleFilmItems()
        if(cleanFilms){
            view?.resetFilms()
        }
        view?.showFilms(film!!, getMedia(numbers.sorted()))

        if(mIdlingResource != null) {
            decrementIdlingResource()
        }
    }

    override fun getMedia(medianList: List<Double>): Double {
        return if (medianList.size % 2 == 0) {
            (medianList[medianList.size / 2] + medianList[medianList.size / 2 - 1]) / 2
        }else{
            medianList[medianList.size / 2]
        }
    }

    override fun onError() {
    }

    override fun getFirstGenreInSearch(genre: String): String{
        return when {
            genre.toUpperCase().contains(SCIENCE_FICTION) -> checkIfScienceFictionIsFirstGenre(genre)
            genre.contains(" ") -> getFirstGenre(genre)
            else -> genre
        }
    }

    private fun checkIfScienceFictionIsFirstGenre(genre: String): String{
        return if(genre.toUpperCase().startsWith(SCIENCE)){
            SCIENCE_FICTION
        }else{
            getFirstGenre(genre)
        }
    }

    private fun searchGenre(itemToSearch: String): Boolean {
        val genresArray = ApplicationConfig.applicationContext().resources.getStringArray(R.array.genres)

        for (genre in genresArray) {
                if(genre.toUpperCase() == itemToSearch.toUpperCase()){
                   return true
                }
            }
        return false
    }

    private fun getFirstGenre(genre: String): String{
        return genre.substring(0, genre.indexOf(' '))
    }

    override fun onItemSave(film: Film, isSave: Boolean, clickDetail: Boolean) {
        when {
            clickDetail -> view?.openDetail(film)
            isSave -> {
                film.favourite = isSave
                favouriteRepository.addFavourite(film)
            }
            else -> {
                favouriteRepository.removeFavourites(film)
            }
        }
    }

    //Testing methods avoid to crash in test getting the context application
    override fun doSearchForTesting(textToSearch: String, genres: List<String>) {
        if(searchGenreTest(textToSearch, genres)) {
            this.searchGenre = textToSearch
            checkIfDataExistInMemory(textToSearch, 0, 20)
        }else{
            view?.genreSearchError()
        }
    }

    private fun searchGenreTest(itemToSearch: String, genresArray: List<String>): Boolean {
        for (genre in genresArray) {
            if(genre.toUpperCase() == itemToSearch.toUpperCase()){
                return true
            }
        }
        return false
    }
}