package com.filmfy


import android.content.Context
import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.di.applicationModule
import com.filmfy.domain.entitites.Film
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.filmfy.utils.fackeFilm
import com.filmfy.utils.fackeOneFilmInArray
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock

class FavouritePresenterTest: KoinTest {

    private val context: Context= mock()
    private val favouriteRepository: FavouritesContract.Model<Film> by inject()
    private val mView: FavouritesContract.View = mock()
    private val presenter: FavouritesContract.Presenter by inject { parametersOf(mView) }

    @Before
    fun setUp() {
        startKoin {
            androidContext(context)
            modules(applicationModule)
        }
        declareMock<FavouritesContract.Model<Film>>()
    }

    @Test
    fun remove_film_in_favourites(){
        presenter.onItemSave(fackeFilm(), isSave = false, clickDetail = false)
        verify(favouriteRepository).removeFavourites(fackeFilm())
    }

    @Test
    fun save_film_in_favourites(){
        presenter.onItemSave(fackeFilm(), isSave = true, clickDetail = false)
        verify(favouriteRepository).addFavourite(fackeFilm())
    }

    @Test
    fun no_show_films_if_no_films(){
        presenter.getFilms()
        verify(mView, never()).showFilms(fackeOneFilmInArray())
    }

    @After
    fun after() {
        stopKoin()
    }
}