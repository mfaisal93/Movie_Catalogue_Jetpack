package com.faisal.moviecataloguesubmission3.view.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
        fun getMovie(): LiveData<List<MovieEntity>> = catalogueRepository.getMovie()
}