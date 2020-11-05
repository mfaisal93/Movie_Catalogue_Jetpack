package com.faisal.moviecataloguesubmission3.view.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.view.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.items.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()

    fun setMovie(movie: List<MovieEntity>?) {
        if (movie == null) return
        listMovie.clear()
        listMovie.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return MovieViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                tv_title.text = movie.title
                tv_release.text = movie.releaseDate
                Glide.with(itemView.context)
                    .load(resources.getString(R.string.api_img)+movie.poster)
                    .into(img_poster)
                setOnClickListener {
                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
                    }
                    context.startActivity(intent)
                }

            }
        }
    }

}