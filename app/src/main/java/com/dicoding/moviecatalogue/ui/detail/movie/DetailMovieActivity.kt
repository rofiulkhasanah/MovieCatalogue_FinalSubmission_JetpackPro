package com.dicoding.moviecatalogue.ui.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.moviecatalogue.databinding.MovieDetailBinding
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Resource
import com.dicoding.moviecatalogue.vo.Status

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailBinding: MovieDetailBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding

    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie.observe(this, {
                    if (it != null) {
                        when (it.status) {
                            Status.SUCCESS -> if (it.data != null) {
                                populateMovie(it)
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateMovie(movie: Resource<MovieEntity>) {
        detailBinding.apply {
            tvMovieTitle.text = movie.data?.title
            tvMovieDescription.text = movie.data?.overview
            tvMovieDate.text = movie.data?.release_date
            tvMovieRating.text = resources.getString(R.string.rating, movie.data?.vote_average)
            Glide.with(this@DetailMovieActivity)
                .load(movie.data?.baseURL.plus(movie.data?.poster_path))
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgMovieImage)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        this.menu = menu
        viewModel.getMovie.observe(this, { mMovie ->
            if (mMovie != null) {
                if (mMovie.data != null) {
                    val state = mMovie.data.favorited
                    setFavoriteState(state)
                }
            }
        })
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavoriteMovie()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }
}