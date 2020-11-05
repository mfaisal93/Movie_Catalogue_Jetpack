package com.faisal.moviecataloguesubmission3.view.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.utils.DataCatalogue
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp(){
        viewModel = DetailTvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataCatalogue.generateTvShow()
        viewModel.setTvShow(dummyTvShow[0])
        val tvSHowEntities = viewModel.getTvShow().value
        assertNotNull(tvSHowEntities)
        assertEquals(dummyTvShow[0], tvSHowEntities)

        if (this::observer.isInitialized){
            viewModel.getTvShow().observeForever(observer)
            verify(observer).onChanged(dummyTvShow[0])
        }
    }
}