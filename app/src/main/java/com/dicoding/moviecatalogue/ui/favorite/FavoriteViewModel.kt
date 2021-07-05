package com.dicoding.moviecatalogue.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity

class FavoriteViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = dataRepository.getFavoritedMovies()

    fun setMovieFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorited
        dataRepository.setMovieFavorite(movieEntity, newState)
    }

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> =
        dataRepository.getFavoritedTvShows()

    fun setTvShowFavorite(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.favorited
        dataRepository.setTvShowFavorite(tvShowEntity, newState)
    }
}