package com.faisal.moviecataloguesubmission3.data.source.remote.api

import com.faisal.moviecataloguesubmission3.data.source.remote.response.MovieResponseList
import com.faisal.moviecataloguesubmission3.data.source.remote.response.TvShowResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET("discover/movie/?api_key=6bb3ab771fecb31508a3a12094d5f4b3&language=en-US")
    fun listMovies (@Query("movie") movies: String?): Call<MovieResponseList>

    @GET("discover/tv/?api_key=6bb3ab771fecb31508a3a12094d5f4b3&language=en-US")
    fun listTvShow (@Query("tv") tv_show: String?): Call<TvShowResponseList>
}