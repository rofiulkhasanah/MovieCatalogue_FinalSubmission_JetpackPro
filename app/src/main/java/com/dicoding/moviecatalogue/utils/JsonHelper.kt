package com.dicoding.moviecatalogue.utils

import android.content.Context
import com.dicoding.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val setBuffer = ByteArray(`is`.available())
            `is`.read(setBuffer)
            `is`.close()
            String(setBuffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val movieList = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val original_title = movie.getString("original_title")
                val overview = movie.getString("overview")
                val poster_path = movie.getString("poster_path")
                val release_date = movie.getString("release_date")
                val vote_average = movie.getString("vote_average")

                val movieResponse = MovieResponse(
                    id.toInt(),
                    original_title,
                    overview,
                    poster_path,
                    release_date,
                    vote_average.toDouble()
                )
                movieList.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieList
    }

    fun loadTvShow(): List<TvShowResponse> {
        val tvShowList = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("id")
                val name = tvShow.getString("name")
                val overview = tvShow.getString("overview")
                val poster_path = tvShow.getString("poster_path")
                val vote_average = tvShow.getString("vote_average")

                val tvShowResponse =
                    TvShowResponse(id.toInt(), name, overview, poster_path, vote_average.toDouble())
                tvShowList.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvShowList
    }
}