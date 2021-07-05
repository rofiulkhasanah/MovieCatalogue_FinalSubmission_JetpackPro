package com.dicoding.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao).apply {
                INSTANCE = this
            }
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getMovies()
    fun getFavoritedMovies(): DataSource.Factory<Int, MovieEntity> =
        mCatalogueDao.getFavoritedMovie()

    fun getMovieById(movieId: String): LiveData<MovieEntity> =
        mCatalogueDao.getMovieById(movieId)

    fun insertMovies(movies: List<MovieEntity>) = mCatalogueDao.insertMovies(movies)
    fun setMoviesFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mCatalogueDao.updateMovie(movie)
    }

    fun insertMovie(movie: MovieEntity) = mCatalogueDao.updateMovie(movie)

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getTvShows()
    fun getFavoritedTvShows(): DataSource.Factory<Int, TvShowEntity> =
        mCatalogueDao.getFavoritedTvShows()

    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> =
        mCatalogueDao.getTvShowById(tvShowId)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mCatalogueDao.insertTvShows(tvShows)
    fun setTvShowsFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorited = newState
        mCatalogueDao.updateTvShow(tvShow)
    }

    fun insertTvShow(tvShow: TvShowEntity) = mCatalogueDao.updateTvShow(tvShow)

}