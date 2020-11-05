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
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.description_movie.*

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: DetailMovieViewModel
    var id: Int? = 0
    private var movieDB = MovieEntity()

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movie = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        if (movie != null){
            viewModel.setMovie(movie)
        }
        viewModel.getMovie().observe(this, Observer {
            id = it.id
            title = it.title
            Glide.with(this)
                .load(getString(R.string.api_img_detail)+it.poster)
                .into(img_poster_movie)
            tv_overview_movie.text = it.overView
            tv_release_movie.text = it.releaseDate
            tv_title_movie.text = it.title
            tv_user_score_movie.text = it.voteAverage
            movieDB = MovieEntity(it.id,it.title,it.poster,it.releaseDate,it.overView,it.voteAverage)

            favored()
        })

        floating_ab_movie.setOnClickListener(this)

    }

    private fun favored(){
                if (viewModel.checkMovieDB(id)) {
                    floating_ab_movie.setImageResource(R.drawable.ic_favorite)
                }else{
                    floating_ab_movie.setImageResource(R.drawable.ic_favorite_border)
                }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        if (viewModel.checkMovieDB(id)) {
                viewModel.deleteMovieFavorite(movieDB)
                Toast.makeText(this,getString(R.string.delete),Toast.LENGTH_SHORT).show()
                floating_ab_movie.setImageResource(R.drawable.ic_favorite_border)
            } else {
                viewModel.insertMovieFavorite(movieDB)
                Toast.makeText(this,getString(R.string.save),Toast.LENGTH_SHORT).show()
                floating_ab_movie.setImageResource(R.drawable.ic_favorite)
            }
    }

}
