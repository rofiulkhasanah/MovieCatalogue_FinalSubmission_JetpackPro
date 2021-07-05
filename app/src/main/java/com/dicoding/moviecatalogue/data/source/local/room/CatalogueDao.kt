package com.dicoding.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface CatalogueDao {

    @Query("SELECT * FROM MovieEntities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM MovieEntities WHERE favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM MovieEntities WHERE id = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM TvShowEntities")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM TvShowEntities WHERE favorited = 1")
    fun getFavoritedTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM TvShowEntities WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShows: TvShowEntity)
}