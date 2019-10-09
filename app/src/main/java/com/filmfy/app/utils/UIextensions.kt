package com.filmfy.app.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import com.filmfy.data.network.Api
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

fun Activity.hideSoftKeyboard() {
    val focusedView = currentFocus
    focusedView?.let { view ->
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun showToast(context: Context, strError: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, strError, length).show()
}

fun inflate(context: Context, viewId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(viewId, parent, attachToRoot)
}

fun ImageView.loadImage(itemFilm: String) {
    val picasso = Picasso.get()
    picasso.load(Api().TMDB_IMAGEURL + itemFilm)
        .networkPolicy(NetworkPolicy.NO_CACHE)
        .memoryPolicy(MemoryPolicy.NO_STORE)
        .memoryPolicy(MemoryPolicy.NO_CACHE)
        .into(this)
}
