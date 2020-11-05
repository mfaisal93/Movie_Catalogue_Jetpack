package com.faisal.moviecataloguesubmission3.view.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import kotlinx.android.synthetic.main.description_tv_show.*

class DetailTvShowActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: DetailTvShowViewModel
    var id: Int? = 0
    private var tvDB = TvShowEntity()

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]
        val tvShow = intent.getParcelableExtra<TvShowEntity>(EXTRA_TV_SHOW)
        if (tvShow != null){
            viewModel.setTvShow(tvShow)
        }
        viewModel.getTvShow().observe(this, Observer {
        Glide.with(this).load(getString(R.string.api_img_detail)+it.poster).into(img_poster_tv_show)
            id = it.id
            title = it.title
            tv_title_tv_show.text = it.title
            tv_overview_tv_show.text = it.overView
            tv_release_tv_show.text = it.releaseDate
            tv_user_score_tv_show.text= it.voteAverage

            tvDB = TvShowEntity(it.id,it.title,it.poster,it.releaseDate,it.overView,it.voteAverage)

            favored()
        })

        floating_ab_tv.setOnClickListener(this)
    }

    private fun favored(){
        if (viewModel.checkTvDB(id)){
            floating_ab_tv.setImageResource(R.drawable.ic_favorite)
        }else{
            floating_ab_tv.setImageResource(R.drawable.ic_favorite_border)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        if (viewModel.checkTvDB(id)){
            viewModel.deleteTvShowFavorite(tvDB)
            floating_ab_tv.setImageResource(R.drawable.ic_favorite_border)
            Toast.makeText(this,getString(R.string.delete), Toast.LENGTH_SHORT).show()
        }else{
            viewModel.insertTvShowFavorite(tvDB)
            floating_ab_tv.setImageResource(R.drawable.ic_favorite)
            Toast.makeText(this,getString(R.string.save),Toast.LENGTH_SHORT).show()
        }
    }
}
