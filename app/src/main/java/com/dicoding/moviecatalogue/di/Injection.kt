package com.dicoding.moviecatalogue.di

import android.content.Context
import com.dicoding.moviecatalogue.data.DataRepository
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.room.CatalogueDatabase
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.utils.AppExecutors
import com.dicoding.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val database = CatalogueDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors)

    }
}