package com.filmfy.di

import androidx.room.Room
import com.filmfy.app.ui.favourite.FavouritesContract
import com.filmfy.app.ui.favourite.FavouritesPresenter
import com.filmfy.app.ui.filmDetail.FilmDetailContract
import com.filmfy.app.ui.filmDetail.FilmDetailPresenter
import com.filmfy.app.ui.search.SearchContract
import com.filmfy.app.ui.search.SearchImpl
import com.filmfy.app.ui.search.SearchPresenter
import com.filmfy.data.database.film.FilmDatabase
import com.filmfy.data.repository.FavouriteRepository
import com.filmfy.data.repository.GenreRepository
import com.filmfy.domain.entitites.Film
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module(override = true) {
    factory<SearchContract.Presenter> { (view: SearchContract.View) -> SearchPresenter(view, mSearchImpl = get()) }
    factory{ SearchImpl() }
    single<SearchContract.Model<Film>> { GenreRepository }

    factory<FavouritesContract.Presenter> { (view: FavouritesContract.View) -> FavouritesPresenter(view) }
    single<FavouritesContract.Model<Film>> { FavouriteRepository }
    factory<FilmDetailContract.Presenter> { (view: FilmDetailContract.View) -> FilmDetailPresenter(view) }

    single {
        Room.databaseBuilder(androidContext(), FilmDatabase::class.java, "film-database").allowMainThreadQueries().build()
    }
}