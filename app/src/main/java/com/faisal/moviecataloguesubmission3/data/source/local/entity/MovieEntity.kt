package com.faisal.moviecataloguesubmission3.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movieFavorite")
data class MovieEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "poster")
    var poster: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @ColumnInfo(name = "overView")
    var overView: String? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: String? = null
) : Parcelable