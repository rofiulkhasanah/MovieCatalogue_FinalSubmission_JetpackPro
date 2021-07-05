package com.dicoding.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.vo.Resource

class TvShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getTVShow(): LiveData<Resource<PagedList<TvShowEntity>>> = dataRepository.getAllTvSHow()
}