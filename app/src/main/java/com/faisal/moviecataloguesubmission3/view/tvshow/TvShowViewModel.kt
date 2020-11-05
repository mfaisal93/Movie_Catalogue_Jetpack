package com.faisal.moviecataloguesubmission3.view.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity

class TvShowViewModel (private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getTvShow(): LiveData<List<TvShowEntity>> = catalogueRepository.getTvShow()
}