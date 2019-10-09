package com.filmfy.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.filmfy.domain.entitites.Cast
import com.filmfy.domain.entitites.Genres
import com.filmfy.domain.entitites.Poster
import java.util.*


class FilmTypeConverters {

    private var gson = Gson()

    @TypeConverter
    fun fromGenres(data: String?): List<Genres>? {
        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<ArrayList<Genres>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun genresListToString(someObjects: List<Genres>?): String? {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun fromCast(data: String?): List<Cast>? {
        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<ArrayList<Cast>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun castListToString(someObjects: List<Cast>?): String? {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun toPoster(json: String): Poster? {
        val type = object : TypeToken<Poster>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun posterToJson(poster: Poster?) = gson.toJson(poster)
}