package com.filmfy

import com.filmfy.app.ui.filmDetail.FilmDetailContract
import com.filmfy.di.applicationModule
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.filmfy.utils.fackeFilm
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject

class FilmDetailPresenterTest: KoinTest {

    private val mView: FilmDetailContract.View = mock()
    private val presenter: FilmDetailContract.Presenter by inject { parametersOf(mView) }

    @Before
    fun setUp() {
        startKoin {
            modules(applicationModule)
        }
    }

    @Test
    fun check_if_show_data_film(){
        presenter.handleIntentData(fackeFilm())
        verify(mView).showData(fackeFilm())
    }

    @Test
    fun check_if_no_data_film_show_error(){
        presenter.handleIntentData(null)
        verify(mView).errorDisplayingDetail()
    }

    @After
    fun after() {
        stopKoin()
    }
}