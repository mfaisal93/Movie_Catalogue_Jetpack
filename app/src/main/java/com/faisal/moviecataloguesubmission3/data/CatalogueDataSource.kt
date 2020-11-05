package com.faisal.moviecataloguesubmission3.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity

interface CatalogueDataSource {

    fun getMovie(): LiveData<List<MovieEntity>>

    fun getTvShow(): LiveData<List<TvShowEntity>>

    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>>

    fun getTvShowFavorite(): LiveData<PagedList<TvShowEntity>>

    fun insertMovieFavorite(movieFavorite: MovieEntity)

    fun insertTvShowFavorite(tvShowFavorite: TvShowEntity)

    fun deleteMovieFavorite(movieFavorite: MovieEntity)

    fun deleteTvShowFavorite(tvShowFavorite: TvShowEntity)

    fun checkMovieDB(id: Int?): Boolean

    fun checkTvDB(id: Int?): Boolean
}