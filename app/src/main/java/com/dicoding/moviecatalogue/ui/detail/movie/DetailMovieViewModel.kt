package com.dicoding.moviecatalogue.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.vo.Resource

class DetailMovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    var movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var getMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        dataRepository.getMovieById(mMovieId)
    }

    fun setFavoriteMovie() {
        val movieResource = getMovie.value
        if (movieResource != null) {
            val dataMovie = movieResource.data
            if (dataMovie != null) {
                val newState = !dataMovie.favorited
                dataRepository.setMovieFavorite(dataMovie, newState)
            }
        }
    }
}