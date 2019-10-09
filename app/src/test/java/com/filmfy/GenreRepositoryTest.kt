package com.filmfy

import com.filmfy.app.ui.search.SearchContract
import com.filmfy.di.applicationModule
import com.filmfy.domain.entitites.Film
import com.nhaarman.mockito_kotlin.mock
import com.filmfy.utils.fackeFilms
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito
import java.io.IOException


class GenreRepositoryTest: KoinTest {

    private val genreRepository: SearchContract.Model<Film> by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(applicationModule)
        }
    }

    @Test
    fun check_save_genre() {
        genreRepository.addFilms("action", fackeFilms())
        val checkoutGet = genreRepository.getFilms("action")

        Assert.assertNotNull(checkoutGet)
        Assert.assertEquals(fackeFilms()[0].id, checkoutGet!![0].id)
    }

    @Test
    @Throws(IOException::class)
    fun check_get_action_films() {
        val mock = mock<SearchContract.Model<Film>>()

        Assert.assertNotNull(fackeFilms())
        Mockito.`when`(mock.getFilms("action")).thenReturn(fackeFilms())
    }

    @After
    fun after() {
        stopKoin()
    }
}