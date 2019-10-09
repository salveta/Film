package com.filmfy.domain.entitites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

data class FilmRequest (val metadata : Metadata, val data : ArrayList<Film>)
data class Metadata (val offset : Int, val limit : Int, val total : Int)

@Entity(tableName = "film")
@Parcelize
data class Film (@PrimaryKey(autoGenerate = true) val uid: Int?, val id : Int, val title : String, val tagline : String, val overview : String, val popularity : Double, val rating : Double, val ratingCount : Int, val runtime : Int, val releaseDate : String, val revenue : Int, val budget : Int, val posterPath : String, val originalLanguage : String, val genres : List<Genres>?, val cast : List<Cast>?, val poster : Poster?, var favourite: Boolean= false): Parcelable
@Parcelize
data class Genres (val id : Int, val name : String): Parcelable
@Parcelize
data class Cast (val id : Int, val gender : Int, val name : String, val character : String, val profilePath : String, val profileImage : ProfileImage): Parcelable
@Parcelize
data class Poster (val fullPath : String, val size : String): Parcelable
@Parcelize
data class ProfileImage (val fullPath : String, val size : String): Parcelable