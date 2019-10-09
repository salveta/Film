package com.filmfy.utils

import com.filmfy.domain.entitites.Film

fun films(): ArrayList<Film>{
    val films = ArrayList<Film>()

    val film1 = Film(
        1, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 6.1, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film2 = Film(
        2, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.0, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film3 = Film(
        3, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.5, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film4 = Film(
        4, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 6.1, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film5 = Film(
        5, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.0, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film6 = Film(
        6, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 6.1, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film7 = Film(
        7, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.0, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film8 = Film(
        8, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.5, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    val film9 = Film(
        9, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 8.5, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
    films.add(film1)
    films.add(film2)
    films.add(film3)
    films.add(film4)
    films.add(film5)
    films.add(film6)
    films.add(film7)
    films.add(film8)
    films.add(film9)

    return films
}

fun filmFacke(): Film {
    return Film(
        1, 1724, "The incredible Hulk", "You'll like him when he's angry.",
        "Scientist Bruce Banner scours the planet for an antidote to the unbridled force of rage within...",
        22.619048, 6.1, 4283, 114, "2008-06-12", 163712074, 150000000,
        "/bleR2qj9UluYl7x0Js7VXuLhV3s.jpg", "en", null, null, null
    )
}
