package com.dicoding.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.vo.Resource

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = dataRepository.getAllMovies()
}