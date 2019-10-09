package com.filmfy.app.ui.filmDetail

import android.os.Bundle
import com.filmfy.R
import com.filmfy.app.base.GenericToolbarActivity
import com.filmfy.app.utils.ArgumentNameConfig
import com.filmfy.app.utils.loadImage
import com.filmfy.app.utils.showToast
import com.filmfy.domain.entitites.Film
import kotlinx.android.synthetic.main.film_detail_activity.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FilmDetailActivity: GenericToolbarActivity(), FilmDetailContract.View {

    private val presenter: FilmDetailContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_detail_activity)

        presenter.handleIntentData(intent?.extras?.getParcelable(ArgumentNameConfig.FILM))
    }

    override fun showData(film: Film?) {
        film?.let {
            configureActionBar(film.title)
            imFilm.loadImage(film.posterPath)
        }
    }

    override fun errorDisplayingDetail() {
        showToast(this@FilmDetailActivity, getString(R.string.error_display_data))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}