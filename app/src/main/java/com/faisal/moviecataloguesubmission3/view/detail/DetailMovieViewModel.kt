package com.faisal.moviecataloguesubmission3.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    private val movieEntity = MutableLiveData<MovieEntity>()

    fun getMovie():LiveData<MovieEntity> = this.movieEntity

    fun setMovie(movieEntity: MovieEntity){
        this.movieEntity.postValue(movieEntity)
    }

    fun checkMovieDB(id: Int?):Boolean = catalogueRepository.checkMovieDB(id)

    fun insertMovieFavorite(movieFavorite: MovieEntity) = catalogueRepository.insertMovieFavorite(movieFavorite)

    fun deleteMovieFavorite(movieFavorite: MovieEntity) = catalogueRepository.deleteMovieFavorite(movieFavorite)
}