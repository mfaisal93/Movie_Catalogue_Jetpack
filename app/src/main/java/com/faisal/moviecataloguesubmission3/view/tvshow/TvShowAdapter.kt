package com.faisal.moviecataloguesubmission3.view.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.view.detail.DetailTvShowActivity
import kotlinx.android.synthetic.main.items.view.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(tvShow : List<TvShowEntity>?){
        if (tvShow == null) return
        listTvShow.clear()
        listTvShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvSHow = listTvShow[position]
        holder.bind(tvSHow)
    }

    class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow :TvShowEntity){
            with(itemView){
                tv_title.text = tvShow.title
                tv_release.text = tvShow.releaseDate
                Glide.with(itemView.context).load(resources.getString(R.string.api_img)+tvShow.poster)
                    .into(img_poster)
                setOnClickListener {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}