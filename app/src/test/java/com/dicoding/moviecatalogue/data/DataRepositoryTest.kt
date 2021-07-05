package com.dicoding.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.utils.*
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DataRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val dataRepository = FakeDataRepository(remote, local, appExecutors)

    private val movieResponse = DataTMDB.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id

    private val tvShowResponse = DataTMDB.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id

    private val testExecutors: AppExecutors = AppExecutors(TestExecutors(), TestExecutors(), TestExecutors())

    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        dataRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPageList(DataTMDB.generateRemoteDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieById() {
        val dataMovie = DataTMDB.generateMovies()[0]
        val movieId = dataMovie.id

        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = dataMovie
        `when`(local.getMovieById(movieId)).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(dataRepository.getMovieById(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.title)
        assertEquals(movieResponse[0].title, movieEntities.data?.title)
    }

    @Test
    fun setMovieFavorite() {
        val dataMovie = DataTMDB.generateMovies()[0]
        val newState = !dataMovie.favorited
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setMoviesFavorite(dataMovie, newState)
        dataRepository.setMovieFavorite(dataMovie, newState)
        verify(local, times(1)).setMoviesFavorite(dataMovie, newState)
    }

    @Test
    fun getFavoritedMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoritedMovies()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPageList(DataTMDB.generateMovies()))
        verify(local).getFavoritedMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        dataRepository.getAllTvSHow()
        val tvShowEntities =
            Resource.success(PagedListUtil.mockPageList(DataTMDB.generateRemoteDummyTvShow()))

        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowById() {
        val dataTvShow = DataTMDB.generateTvShow()[0]
        val tvShowId = dataTvShow.id

        val dummyEntity = MutableLiveData<TvShowEntity>()
        dummyEntity.value = dataTvShow
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(dataRepository.getTvShowById(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.name)
        assertEquals(tvShowResponse[0].name, tvShowEntities.data?.name)
    }

    @Test
    fun getFavoritedTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoritedTvShows()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPageList(DataTMDB.generateTvShow()))
        verify(local).getFavoritedTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun setTvShowFavorite() {
        val dataTvShow = DataTMDB.generateTvShow()[0]
        val newState = !dataTvShow.favorited
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).setTvShowsFavorite(dataTvShow, newState)
        dataRepository.setTvShowFavorite(dataTvShow, newState)
        verify(local, times(1)).setTvShowsFavorite(dataTvShow, newState)
    }
}