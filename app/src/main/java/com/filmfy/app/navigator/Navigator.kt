package com.filmfy.app.navigator

import android.content.Context
import android.content.Intent
import com.filmfy.app.ui.favourite.FavouritesActivity
import com.filmfy.app.ui.filmDetail.FilmDetailActivity
import com.filmfy.app.utils.ArgumentNameConfig
import com.filmfy.domain.entitites.Film

class Navigator {

    object Search {
        fun openFavourite(context: Context) {
            val intent = Intent(context, FavouritesActivity::class.java)
            context.startActivity(intent)
        }

        fun openDetail(context: Context, film: Film) {
            val intent = Intent(context, FilmDetailActivity::class.java)
            intent.putExtra(ArgumentNameConfig.FILM, film)
            context.startActivity(intent)
        }
    }
}