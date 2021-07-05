package com.dicoding.moviecatalogue.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.utils.DataTMDB
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val data = DataTMDB.generateTvShow()[0]
    private val tvShowId = data.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(dataRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(data)

        `when`(dataRepository.getTvShowById(tvShowId)).thenReturn(expected)
        viewModel.getTvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(expected.value)
        val expectedValue = expected.value
        val actualValue = viewModel.getTvShow.value
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setTvShowFavorite() {
        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(data)
        val newState = !data.favorited

        `when`(dataRepository.getTvShowById(tvShowId)).thenReturn(expected)
        viewModel.getTvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(expected.value)
        dataRepository.getTvShowById(tvShowId)
        viewModel.setFavorite()

        verify(dataRepository).setTvShowFavorite(expected.value?.data as TvShowEntity, newState)
        verifyNoMoreInteractions(tvShowObserver)

    }
}