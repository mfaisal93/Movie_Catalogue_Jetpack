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
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.view.detail.DetailTvShowActivity
import kotlinx.android.synthetic.main.items.view.*

class TvShowFavoriteAdapter internal constructor(): PagedListAdapter<TvShowEntity, TvShowFavoriteAdapter.TvShowViewHolder>(
    DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShowFavorite = getItem(position)
        if (tvShowFavorite != null){
            holder.bind(tvShowFavorite)
        }
    }

    class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShowFavorite: TvShowEntity){
            with(itemView){
                tv_title.text = tvShowFavorite.title
                tv_release.text = tvShowFavorite.releaseDate
                Glide.with(itemView.context).load(resources.getString(R.string.api_img)+tvShowFavorite.poster)
                    .into(img_poster)
                setOnClickListener {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShowFavorite)
                    }
                    context.startActivity(intent)
                }
            }
        }

    }
}