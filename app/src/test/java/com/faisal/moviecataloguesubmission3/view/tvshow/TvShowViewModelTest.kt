package com.faisal.moviecataloguesubmission3.view.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>
    @Before
    fun setUp(){
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataCatalogue.generateTvShow()
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow().value
        Mockito.verify<CatalogueRepository>(catalogueRepository).getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}