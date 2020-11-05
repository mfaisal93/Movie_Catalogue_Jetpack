package com.faisal.moviecataloguesubmission3.view.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity
import com.faisal.moviecataloguesubmission3.utils.DataCatalogue
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataCatalogue.generateMovie()
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(catalogueRepository.getMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovie().value
        Mockito.verify<CatalogueRepository>(catalogueRepository).getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovie)
    }
}