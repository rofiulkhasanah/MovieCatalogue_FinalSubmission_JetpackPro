package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "TvShowEntities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "poster_path")
    val poster_path: String,


    @ColumnInfo(name = "vote_average")
    val vote_average: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,
) : Parcelable {
    val baseURL: String get() = "https://image.tmdb.org/t/p/w500"
}