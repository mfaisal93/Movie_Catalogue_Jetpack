package com.faisal.moviecataloguesubmission3.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponseList(
    @SerializedName("results")
    val movieResponseList: List<MovieResponse>
)