package com.filmfy.app.ui.favourite

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.GridLayoutManager
import com.filmfy.R
import com.filmfy.app.base.GenericToolbarActivity
import com.filmfy.app.navigator.Navigator
import com.filmfy.app.ui.search.adapter.SearchFilmAdapter
import com.filmfy.domain.entitites.Film
import kotlinx.android.synthetic.main.view_movie_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FavouritesActivity : GenericToolbarActivity(), FavouritesContract.View  {

    private val presenter: FavouritesContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        textViewMovieListCallToAction.text = getString(R.string.favorites_empty_place_holder)
        configureActionBar("")
        presenter.getFilms()
    }

    override fun showFilms(film: ArrayList<Film>) {
        recyclerViewMovieList.visibility = VISIBLE
        textViewMovieListCallToAction.visibility = GONE
        initRecyclerView(film)
    }

    private fun initRecyclerView(film: ArrayList<Film>){
        recyclerViewMovieList?.layoutManager = GridLayoutManager(this, 2)
        recyclerViewMovieList?.adapter = SearchFilmAdapter(0.0, film) { film, isSave, clickDetail ->
            presenter.onItemSave(film, isSave, clickDetail)
        }
    }

    override fun openDetail(film: Film) {
        Navigator.Search.openDetail(this@FavouritesActivity, film)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
