package com.faisal.moviecataloguesubmission3.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM movieFavorite")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowFavorite")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: TvShowEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

    @Delete
    fun deleteTvShow(tvShow: TvShowEntity)

    @Query("SELECT * FROM movieFavorite WHERE id = :id")
    fun checkMovieDB(id : Int?): MovieEntity?

    @Query("SELECT * FROM tvShowFavorite where id = :id")
    fun checkTvDB(id : Int?): TvShowEntity?
}