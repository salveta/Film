package com.filmfy

import android.accounts.NetworkErrorException
import com.filmfy.app.ui.search.SearchContract
import com.filmfy.app.ui.search.SearchImpl
import com.filmfy.data.network.RetrofitAdapter
import com.filmfy.utils.TestSchedulerProvider
import com.filmfy.utils.filmRequestFacke
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.Test
import io.reactivex.schedulers.TestScheduler
import org.koin.test.KoinTest


class SearchImplTest: KoinTest {

    private val callback: SearchContract.Callback? = mock()
    private val api: RetrofitAdapter = mock()
    private lateinit var searchImpl: SearchImpl
    private lateinit var testScheduler: TestScheduler
    private var testSchedulerProvider = TestSchedulerProvider(null)

    @Before
    fun setUp() {
        testScheduler = TestScheduler()
        testSchedulerProvider = TestSchedulerProvider(testScheduler)
        testSchedulerProvider.ui()
        searchImpl = SearchImpl()

        RxAndroidPlugins.setMainThreadSchedulerHandler { testSchedulerProvider.io() }
        RxJavaPlugins.setIoSchedulerHandler { testSchedulerProvider.io() }
    }

    @Test
    fun `load films when data is available`() {
        whenever(api.getFilms()).thenReturn(Observable.just(filmRequestFacke()))

        searchImpl.getfilms("", "", "", "", callback, testSchedulerProvider)
        testScheduler.triggerActions()

        verify(callback)?.onResponseSearchFilm(any())
    }
}