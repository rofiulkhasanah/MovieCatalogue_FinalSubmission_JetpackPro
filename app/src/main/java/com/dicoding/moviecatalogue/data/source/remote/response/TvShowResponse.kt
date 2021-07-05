package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
    val id: Int,
    val name: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double
) : Parcelable