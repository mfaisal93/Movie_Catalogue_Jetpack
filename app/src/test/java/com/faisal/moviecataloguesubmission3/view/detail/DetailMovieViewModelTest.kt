package com.faisal.moviecataloguesubmission3.view.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        catalogueRepository.getMovie()
        val dummyMovie = DataCatalogue.generateMovie()
        viewModel.setMovie(dummyMovie[0])
        val movieEntities = viewModel.getMovie().value
        assertNotNull(movieEntities)
        assertEquals(dummyMovie[0], movieEntities)

        if (this::observer.isInitialized){
            viewModel.getMovie().observeForever(observer)
            Mockito.verify(observer).onChanged(dummyMovie[0])
        }
    }
}