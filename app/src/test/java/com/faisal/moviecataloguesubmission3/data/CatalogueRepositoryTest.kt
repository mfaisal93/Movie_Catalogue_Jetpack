package com.faisal.moviecataloguesubmission3.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.faisal.moviecataloguesubmission3.data.source.local.LocalDataSource
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.data.source.remote.RemoteDataSource
import com.faisal.moviecataloguesubmission3.utils.AppExecutors
import com.faisal.moviecataloguesubmission3.utils.DataCatalogue
import com.faisal.moviecataloguesubmission3.utils.LiveDataTestUtil
import com.faisal.moviecataloguesubmission3.utils.PagedListUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote,local,appExecutors)

    private val movieResponse = DataCatalogue.generateRemoteMovie()
    private val tvShowResponse = DataCatalogue.generateRemoteTvShow()

    private val movieDB = DataCatalogue.generateMovie()
    private val tvDB = DataCatalogue.generateTvShow()
    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallBack).onMovieReceived(movieResponse)
            null
        }.`when`(remote).getMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getMovie())
        verify(remote).getMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size, movieEntities.size)
    }

    @Test
    fun getTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallBack).onTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShow(any())
        val  tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getTvShow())
        verify(remote).getTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size, tvShowEntities.size)
    }

    @Test
    fun getMovieFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovieFavorite()).thenReturn(dataSourceFactory)
        catalogueRepository.getMovieFavorite()

        val movieEntities = PagedListUtil.mockPagedList(DataCatalogue.generateMovie())
        verify(local).getMovieFavorite()
        assertNotNull(movieEntities)
        assertEquals(movieDB.size, movieEntities.size)
    }

    @Test
    fun getTvShowFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFavorite()).thenReturn(dataSourceFactory)
        catalogueRepository.getTvShowFavorite()

        val tvShowEntities = PagedListUtil.mockPagedList(DataCatalogue.generateTvShow())
        verify(local).getTvShowFavorite()
        assertNotNull(tvShowEntities)
        assertEquals(tvDB.size, tvShowEntities.size)
    }
}