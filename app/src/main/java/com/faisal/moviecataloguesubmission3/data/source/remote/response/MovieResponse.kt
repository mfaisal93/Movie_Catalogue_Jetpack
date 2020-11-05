package com.faisal.moviecataloguesubmission3.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("poster_path")
    var poster: String? = null,

    @SerializedName("release_date")
    var releaseDate: String? = null,

    @SerializedName("overview")
    var overView: String? = null,

    @SerializedName("vote_average")
    var voteAverage: String? = null
)