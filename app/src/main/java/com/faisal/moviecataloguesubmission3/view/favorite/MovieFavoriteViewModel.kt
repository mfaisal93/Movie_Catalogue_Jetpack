package com.faisal.moviecataloguesubmission3.view.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity

class MovieFavoriteViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getMovieFavorite()
}