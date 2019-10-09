package com.filmfy.app.ui.search.adapter

import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.filmfy.R
import com.filmfy.app.utils.inflate
import com.filmfy.app.utils.loadImage
import com.filmfy.domain.entitites.Film
import kotlinx.android.synthetic.main.listitem_movie.view.*

class SearchFilmAdapter(private var median: Double, private var listFilm: ArrayList<Film>, private val listener: (Film, Boolean, Boolean) -> Unit) : RecyclerView.Adapter<SearchFilmAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(inflate(parent.context, R.layout.listitem_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(median, listFilm[position], listener)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(median: Double, itemFilm: Film, listener: (Film, Boolean, Boolean) -> Unit) = with(itemView) {

            if(itemFilm.rating >= median){
                imageViewMovieListItemStar.visibility = VISIBLE
            }else{
                imageViewMovieListItemStar.visibility = GONE
            }

            imageViewMovieListItemFavorite.isActivated = itemFilm.favourite
            imageViewMovieListItemImage.loadImage(itemFilm.posterPath)

            itemView.imageViewMovieListItemFavorite.setOnClickListener{
                imageViewMovieListItemFavorite.isActivated = !imageViewMovieListItemFavorite.isActivated
                listener(itemFilm, imageViewMovieListItemFavorite.isActivated , false)
            }

            itemView.setOnClickListener{
                listener(itemFilm, false, true)
            }
        }
    }

    fun updateFavaoriteFilm(index: Int){
        notifyItemChanged(index)
    }

    fun update(median: Double){
        this.median = median
        notifyDataSetChanged()
    }
}