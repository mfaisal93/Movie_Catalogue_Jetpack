package com.faisal.moviecataloguesubmission3.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.di.Injection
import com.faisal.moviecataloguesubmission3.view.detail.DetailMovieViewModel
import com.faisal.moviecataloguesubmission3.view.detail.DetailTvShowViewModel
import com.faisal.moviecataloguesubmission3.view.favorite.MovieFavoriteViewModel
import com.faisal.moviecataloguesubmission3.view.favorite.TvShowFavoriteViewModel
import com.faisal.moviecataloguesubmission3.view.movie.MovieViewModel
import com.faisal.moviecataloguesubmission3.view.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.providerRepository(context)
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(
                    mCatalogueRepository
                ) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java)->{
                TvShowViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(
                   mCatalogueRepository
                ) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java)->{
                DetailTvShowViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java)->{
                MovieFavoriteViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavoriteViewModel::class.java)->{
                TvShowFavoriteViewModel(mCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}