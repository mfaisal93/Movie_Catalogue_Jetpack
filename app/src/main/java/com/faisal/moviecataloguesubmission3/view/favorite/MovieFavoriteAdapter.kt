package com.faisal.moviecataloguesubmission3.view.favorite

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.view.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.items.view.*

class MovieFavoriteAdapter internal constructor() : PagedListAdapter<MovieEntity, MovieFavoriteAdapter.MovieViewHolder>(DIFF_CALLBACK) {
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieFavorite = getItem(position)
        if(movieFavorite != null){
        holder.bind(movieFavorite)
        }

    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movieFavorite : MovieEntity){
            with(itemView){
                tv_title.text = movieFavorite.title
                tv_release.text = movieFavorite.releaseDate
                Glide.with(itemView.context).load(resources.getString(R.string.api_img)+movieFavorite.poster)
                    .into(img_poster)
                setOnClickListener {
                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movieFavorite)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}