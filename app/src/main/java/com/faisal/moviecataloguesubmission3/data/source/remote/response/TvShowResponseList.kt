package com.faisal.moviecataloguesubmission3.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponseList(
    @SerializedName("results")
    val tvShowResponseList: List<TvShowResponse>
)