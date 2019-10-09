package com.filmfy.app.widget

import com.filmfy.domain.entitites.Film

class RxEvent {
    data class UpdateFilmFavourite(val film: Film, val isSave: Boolean)
}