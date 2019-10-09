package com.filmfy

import androidx.test.platform.app.InstrumentationRegistry
import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.di.applicationModule
import com.filmfy.domain.entitites.Film
import com.filmfy.utils.filmFacke
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class FavouriteRepositoryTest: KoinTest {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val repository: FavouritesContract.Model<Film> by inject()

    @Before
    fun before() {
        stopKoin()
        startKoin {
            androidContext(context)
            modules(applicationModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun insertFilmAndRetrieveData() {
        repository.addFavourite(filmFacke())
        val favourites = repository.getFavourites()

        Assert.assertNotNull(favourites)
        Assert.assertEquals(filmFacke().id, favourites[0].id)
    }

    @Test
    fun insertFilmSavesData() {
        val film = filmFacke()
        repository.addFavourite(film)
        repository.addFavourite(film)

        val filmList = repository.getFavourites()
        assert(filmList.isNotEmpty())
    }

    @Test
    fun clearFilmData() {
        val film = filmFacke()
        repository.addFavourite(film)
        repository.removeFavourites(film)

        val filmList =repository.getFavourites()
        assert(filmList.isEmpty())
    }
}