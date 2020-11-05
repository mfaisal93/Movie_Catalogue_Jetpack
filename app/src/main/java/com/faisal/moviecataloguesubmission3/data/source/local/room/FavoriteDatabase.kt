package com.faisal.moviecataloguesubmission3.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class]
,version = 1,exportSchema = false)
abstract class FavoriteDatabase: RoomDatabase(){
    abstract fun favoriteDao(): FavoriteDao

    companion object{

        @Volatile
        private var INSTANCE: FavoriteDatabase? = null

        fun getInstance(context: Context): FavoriteDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext, FavoriteDatabase::class.java,
                "Favorite.db").allowMainThreadQueries().build()
            }
    }
}