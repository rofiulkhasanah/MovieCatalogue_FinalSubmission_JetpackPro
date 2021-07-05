package com.dicoding.moviecatalogue.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.vo.Resource

class DetailTvShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    var tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var getTvShow: LiveData<Resource<TvShowEntity>> =
        Transformations.switchMap(tvShowId) { mTvShowId ->
            dataRepository.getTvShowById(mTvShowId)
        }

    fun setFavorite() {
        val tvShowResource = getTvShow.value
        if (tvShowResource != null) {
            val dataTvShow = tvShowResource.data
            if (dataTvShow != null) {
                val newState = !dataTvShow.favorited
                dataRepository.setTvShowFavorite(dataTvShow, newState)
            }
        }
    }

}