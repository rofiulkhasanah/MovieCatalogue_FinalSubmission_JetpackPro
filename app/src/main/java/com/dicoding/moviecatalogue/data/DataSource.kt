package com.dicoding.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.vo.Resource

interface DataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvSHow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovieById(movieId: String): LiveData<Resource<MovieEntity>>

    fun getTvShowById(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
}