package com.faisal.moviecataloguesubmission3.di

import android.content.Context
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.LocalDataSource
import com.faisal.moviecataloguesubmission3.data.source.local.room.FavoriteDatabase
import com.faisal.moviecataloguesubmission3.data.source.remote.RemoteDataSource
import com.faisal.moviecataloguesubmission3.utils.AppExecutors

object Injection {

    fun providerRepository(context: Context): CatalogueRepository {
        val remoteDataSource = RemoteDataSource(context)
        val appExecutor = AppExecutors()
        val database = FavoriteDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.favoriteDao())
        return CatalogueRepository.getInstance(remoteDataSource,localDataSource, appExecutor)
    }
}