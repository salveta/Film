package com.filmfy

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.filmfy.data.database.film.FilmDao
import com.filmfy.data.database.film.FilmDatabase
import com.filmfy.domain.entitites.Film
import com.filmfy.utils.filmFacke
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException


class FilmDatabaseTest {
    private lateinit var todoDao: FilmDao
    private lateinit var db: FilmDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, FilmDatabase::class.java).build()
        todoDao = db.filmDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertFilmSavesData() {
        val film = filmFacke()
        todoDao.insertFilm(film)
        todoDao.insertFilm(film)

        val filmList = todoDao.loadAllFilms()
        assert(filmList.isNotEmpty())
    }

    @Test
    @Throws(Exception::class)
    fun insertFilmAndRetrieveData() {
        val film: Film = filmFacke()
        todoDao.insertFilm(film)
        val todoItem = todoDao.loadAllFilms()
        assertThat(todoItem[0].id, equalTo(film.id))
    }

    @Test
    fun clearFilmData() {
        val film = filmFacke()
        todoDao.insertFilm(film)
        todoDao.deleteFilm(film)
        val filmList =todoDao.loadAllFilms()
        assert(filmList.isEmpty())
    }
}