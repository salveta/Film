package com.filmfy.data.network


class Api {

    val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"
//    val BASE_URL = "http://172.16.1.161:4000"
    val BASE_URL = "http://www.mocky.io/" // mock json call if can't run docker


    interface ENDPOINT {
        companion object {
//            const val FILMS = "/movies"
            const val FILMS = "v2/5d9c6bf4310000dca42fc5b7" // mock json call if can't run docker
        }
    }
}