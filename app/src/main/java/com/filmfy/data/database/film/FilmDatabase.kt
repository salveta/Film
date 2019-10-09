package com.filmfy.data.database.film

import androidx.room.*
import com.filmfy.data.database.FilmTypeConverters
import com.filmfy.domain.entitites.Film

@Database(entities = [Film::class], version = 1)
@TypeConverters(FilmTypeConverters::class)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}


@Dao
interface FilmDao {
    @Query("SELECT * FROM film ORDER BY id")
    fun loadAllFilms(): List<Film>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: Film)

    @Delete
    fun deleteFilm(film: Film)
}