package com.faisal.moviecataloguesubmission3.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity

class DetailTvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    private val tvShowEntity = MutableLiveData<TvShowEntity>()

    fun getTvShow(): LiveData<TvShowEntity> = this.tvShowEntity

    fun setTvShow(tvShowEntity: TvShowEntity){
        this.tvShowEntity.postValue(tvShowEntity)
    }

    fun checkTvDB(id: Int?): Boolean = catalogueRepository.checkTvDB(id)

    fun insertTvShowFavorite(tvShowFavorite: TvShowEntity) = catalogueRepository.insertTvShowFavorite(tvShowFavorite)

    fun deleteTvShowFavorite(tvShowFavorite: TvShowEntity) = catalogueRepository.deleteTvShowFavorite(tvShowFavorite)
}