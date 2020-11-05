package com.faisal.moviecataloguesubmission3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.faisal.moviecataloguesubmission3.data.source.local.LocalDataSource
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.data.source.remote.RemoteDataSource
import com.faisal.moviecataloguesubmission3.data.source.remote.response.MovieResponse
import com.faisal.moviecataloguesubmission3.data.source.remote.response.TvShowResponse
import com.faisal.moviecataloguesubmission3.utils.AppExecutors

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
private val appExecutors: AppExecutors) : CatalogueDataSource {

    val movieResult = MutableLiveData<List<MovieEntity>>()
    val tvShowResult = MutableLiveData<List<TvShowEntity>>()

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(
            remote: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors
        ): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remote, localDataSource, appExecutors)
            }
    }

    override fun getMovie(): LiveData<List<MovieEntity>> {
        val movieList = ArrayList<MovieEntity>()
        appExecutors.networkIO().execute {
            remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallBack {
                override fun onMovieReceived(movieResponse: List<MovieResponse>) {
                    for (response in movieResponse) {
                        val movieEntity = MovieEntity(
                            response.id,
                            response.title,
                            response.poster,
                            response.releaseDate,
                            response.overView,
                            response.voteAverage
                        )
                        movieList.add(movieEntity)
                    }
                    movieResult.postValue(movieList)
                }
            })
        }
        return movieResult
        }

    override fun getTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowList = ArrayList<TvShowEntity>()
        appExecutors.networkIO().execute {
            remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowCallBack {
            override fun onTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                for (response in tvShowResponse) {
                    val tvShowEntity = TvShowEntity(
                        response.id,
                        response.title,
                        response.poster,
                        response.releaseDate,
                        response.overView,
                        response.voteAverage
                    )
                    tvShowList.add(tvShowEntity)
                }
                tvShowResult.postValue(tvShowList)
            }
        })  }

        return tvShowResult
    }

    override fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> =
        LivePagedListBuilder(localDataSource.getMovieFavorite(), 20).build()


    override fun getTvShowFavorite(): LiveData<PagedList<TvShowEntity>> =
        LivePagedListBuilder(localDataSource.getTvShowFavorite(), 20).build()


    override fun insertMovieFavorite(movieFavorite: MovieEntity) =
        appExecutors.diskIO().execute { localDataSource.insertMovieFavorite(movieFavorite) }

    override fun insertTvShowFavorite(tvShowFavorite: TvShowEntity) =
        appExecutors.diskIO().execute { localDataSource.insertTvShowFavorite(tvShowFavorite) }


    override fun deleteMovieFavorite(movieFavorite: MovieEntity) =
        appExecutors.diskIO().execute { localDataSource.deleteMovieFavorite(movieFavorite) }

    override fun deleteTvShowFavorite(tvShowFavorite: TvShowEntity) =
        appExecutors.diskIO().execute { localDataSource.deleteTvShowFavorite(tvShowFavorite) }

    override fun checkMovieDB(id: Int?): Boolean =
        localDataSource.checkMovieDB(id)

    override fun checkTvDB(id: Int?): Boolean =
        localDataSource.checkTvDB(id)


}


