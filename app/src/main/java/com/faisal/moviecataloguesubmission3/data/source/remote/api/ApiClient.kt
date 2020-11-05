package com.faisal.moviecataloguesubmission3.data.source.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit =
        retrofit
            ?: Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}