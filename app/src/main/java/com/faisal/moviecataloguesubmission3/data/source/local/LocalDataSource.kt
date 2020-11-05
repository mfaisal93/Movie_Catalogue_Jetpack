package com.faisal.moviecataloguesubmission3.data.source.local

import androidx.paging.DataSource
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.data.source.local.room.FavoriteDao

class LocalDataSource private constructor(private val mFavoriteDao: FavoriteDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(favoriteDao: FavoriteDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(favoriteDao)
    }

    fun getMovieFavorite(): DataSource.Factory<Int,MovieEntity> = mFavoriteDao.getMovie()

    fun getTvShowFavorite(): DataSource.Factory<Int,TvShowEntity> = mFavoriteDao.getTvShow()

    fun insertMovieFavorite(movieFavorite: MovieEntity) = mFavoriteDao.insertMovie(movieFavorite)

    fun insertTvShowFavorite(tvShowFavorite: TvShowEntity) = mFavoriteDao.insertTvShow(tvShowFavorite)

    fun deleteMovieFavorite(movieFavorite: MovieEntity) = mFavoriteDao.deleteMovie(movieFavorite)

    fun deleteTvShowFavorite(tvShowFavorite: TvShowEntity) = mFavoriteDao.deleteTvShow(tvShowFavorite)

    fun checkMovieDB(id: Int?): Boolean = mFavoriteDao.checkMovieDB(id) != null

    fun checkTvDB(id: Int?): Boolean = mFavoriteDao.checkTvDB(id) != null


}