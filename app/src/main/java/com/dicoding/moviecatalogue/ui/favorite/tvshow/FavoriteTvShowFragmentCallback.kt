package com.dicoding.moviecatalogue.ui.favorite.tvshow

import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity

interface FavoriteTvShowFragmentCallback {
    fun onShareTvShowClick(tvShow: TvShowEntity)
}