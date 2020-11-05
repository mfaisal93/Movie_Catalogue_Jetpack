package com.faisal.moviecataloguesubmission3.view.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieFavoriteViewModelTest {

    private lateinit var viewModel: MovieFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieFavoriteViewModel(catalogueRepository)
    }

    @Test
    fun getMovieFavorite() {
        val dummyMovie = pagedList
        `when`(dummyMovie.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getMovieFavorite()).thenReturn(movie)
        val movieEntities = viewModel.getMovieFavorite().value
        verify(catalogueRepository).getMovieFavorite()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovieFavorite().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}