package com.dicoding.moviecatalogue.ui.favorite.movie

import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity

interface FavoriteMovieFragmentCallback {
    fun onShareMovieClick(movie: MovieEntity)
}