package com.faisal.moviecataloguesubmission3.data.source.remote

import android.content.Context
import android.util.Log
import com.faisal.moviecataloguesubmission3.data.source.remote.api.ApiClient
import com.faisal.moviecataloguesubmission3.data.source.remote.api.MovieInterface
import com.faisal.moviecataloguesubmission3.data.source.remote.response.MovieResponse
import com.faisal.moviecataloguesubmission3.data.source.remote.response.MovieResponseList
import com.faisal.moviecataloguesubmission3.data.source.remote.response.TvShowResponse
import com.faisal.moviecataloguesubmission3.data.source.remote.response.TvShowResponseList
import com.faisal.moviecataloguesubmission3.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class RemoteDataSource(var context: Context) {
    private val apiInterface = ApiClient.getClient()
        .create<MovieInterface>()

    fun getMovie(callBack: LoadMovieCallBack) {
        EspressoIdlingResource.increment()

        fun call(): Call<MovieResponseList> = apiInterface.listMovies("movie")

        call().enqueue(object : Callback<MovieResponseList> {
            override fun onResponse(
                call: Call<MovieResponseList>,
                responseList: Response<MovieResponseList>
            ) {
                if (responseList.body() != null) {
                    callBack.onMovieReceived(responseList.body()!!.movieResponseList)
                }
            }

            override fun onFailure(call: Call<MovieResponseList>, t: Throwable) {
                Log.i("ERROR", t.toString())
            }
        })
        EspressoIdlingResource.decrement()
    }

    fun getTvShow(callback: LoadTvShowCallBack) {
        EspressoIdlingResource.increment()

        fun call(): Call<TvShowResponseList> = apiInterface.listTvShow("tv")

        call().enqueue(object : Callback<TvShowResponseList> {
            override fun onResponse(
                call: Call<TvShowResponseList>,
                responseList: Response<TvShowResponseList>
            ) {
                if (responseList.body() != null) {
                    callback.onTvShowReceived(responseList.body()!!.tvShowResponseList)
                }
            }

            override fun onFailure(call: Call<TvShowResponseList>, t: Throwable) {
                Log.i("ERROR", t.toString())
            }
        })
        EspressoIdlingResource.decrement()
    }

    interface LoadMovieCallBack {
        fun onMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowCallBack {
        fun onTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }
}
