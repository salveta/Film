package com.filmfy

import android.content.Context
import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.app.ui.search.SearchContract
import com.filmfy.di.applicationModule
import com.filmfy.domain.entitites.Film
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.filmfy.utils.fackeFilm
import com.filmfy.utils.fackeFilmFavourite
import com.filmfy.utils.fackeFilms
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock


const val SCIENCE_FICTION = "SCIENCE FICTION"
const val TEST_RESOURCE = "action science"
const val ACTION = "action"
const val NO_GENRE = "test"

class SearchPresenterTest: KoinTest {

    private val context: Context = mock()
    private val mView: SearchContract.View = mock()
    private val mCallback: SearchContract.Callback = mock()
    private val presenter: SearchContract.Presenter by inject { parametersOf(mView, mCallback) }
    private val genreRepository: SearchContract.Model<Film> by inject()
    private val favouriteRepository: FavouritesContract.Model<Film> by inject()


    @Before
    fun setUp() {
        startKoin {
            androidContext(context)
            modules(applicationModule)
        }
        declareMock<FavouritesContract.Model<Film>>()
    }


    @Test
    fun save_film_in_favourites(){
        presenter.onItemSave(fackeFilmFavourite(), isSave = true, clickDetail = false)
        verify(favouriteRepository).addFavourite(fackeFilmFavourite())
    }

    @Test
    fun remove_film_in_favourites(){
        presenter.onItemSave(fackeFilm(), isSave = false, clickDetail = false)
        verify(favouriteRepository).removeFavourites(fackeFilm())
    }

    @Test
    fun get_first_genre_in_search(){
        val checkoutGet = presenter.getFirstGenreInSearch(TEST_RESOURCE)
        Assert.assertEquals(ACTION, checkoutGet)
    }

    @Test
    fun get_science_fiction_genre(){
        val checkoutGet = presenter.getFirstGenreInSearch(SCIENCE_FICTION)
        Assert.assertEquals(SCIENCE_FICTION, checkoutGet)
    }

    @Test
    fun get_science_fiction_genre_with_other_genre(){
        val checkoutGet = presenter.getFirstGenreInSearch(SCIENCE_FICTION + ACTION)
        Assert.assertEquals(SCIENCE_FICTION, checkoutGet)
    }

    @Test
    fun get_no_genre_and_diplay_error(){
        presenter.doSearchForTesting(NO_GENRE, fackeGenres())
        verify(mView).genreSearchError()
    }

    @Test
    fun get_median(){
        val median = presenter.getMedia(medianList())
        assertEquals(8.0, median, 0.0)
    }

    @Test
    fun calculate_median_display_elements(){
        presenter.calculateMedia(fackeFilms())
        verify(mView).doVisibleFilmItems()
        verify(mView).showFilms(fackeFilms(), 8.0)
    }

    @Test
    fun check_if_have_to_get_data_from_server_if_load_more(){
        presenter.doSearchForTesting(ACTION, fackeGenres())
        verify(mView, never()).doVisibleFilmItems()
    }

    @Test
    fun check_if_have_to_get_data_from_cache_and_is_display(){
        genreRepository.addFilms(ACTION, fackeFilms())
        presenter.doSearchForTesting(ACTION, fackeGenres())

        verify(mView).doVisibleFilmItems()
        verify(mView).showFilms(fackeFilms(), 8.0)
        genreRepository.clearFilms()
    }

    @After
    fun after() {
        stopKoin()
    }

    private fun medianList(): ArrayList<Double>{
        val numbers = ArrayList<Double>()
        numbers.add(6.0)
        numbers.add(7.3)
        numbers.add(8.0)
        numbers.add(7.5)
        numbers.add(7.5)

        return numbers
    }

    private fun fackeGenres(): List<String>{
        return listOf("Action", "Adventure", "Animation", "Crime", "Drama", "Family")
    }
}