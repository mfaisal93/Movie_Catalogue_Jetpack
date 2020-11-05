package com.faisal.moviecataloguesubmission3.view.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.faisal.moviecataloguesubmission3.data.CatalogueRepository
import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowFavoriteViewModelTest {

    private lateinit var viewModel: TvShowFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowFavoriteViewModel(catalogueRepository)
    }

    @Test
    fun getTvShowFavorite() {
        val dummyTvShow = pagedList
        `when`(dummyTvShow.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShowFavorite()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowFavorite().value
        verify(catalogueRepository).getTvShowFavorite()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShowFavorite().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}