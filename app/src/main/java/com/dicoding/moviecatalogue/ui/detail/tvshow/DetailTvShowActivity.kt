package com.dicoding.moviecatalogue.ui.detail.tvshow

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
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.dicoding.moviecatalogue.databinding.TvShowDetailBinding
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Resource
import com.dicoding.moviecatalogue.vo.Status.*

class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_movie"
    }

    private lateinit var detailBinding: TvShowDetailBinding
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding

    private lateinit var viewModel: DetailTvShowViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailBinding = activityDetailTvShowBinding.detailTvshow

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(DetailTvShowActivity.EXTRA_TVSHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                viewModel.getTvShow.observe(this, {
                    if (it != null) {
                        when (it.status) {
                            SUCCESS -> if (it.data != null) {
                                populateTVShow(it)
                            }
                        }
                    }
                })
            }
        }
    }


    private fun populateTVShow(tvShow: Resource<TvShowEntity>) {
        detailBinding.apply {
            tvTvShowTitle.text = tvShow.data?.name
            tvTvShowDescription.text = tvShow.data?.overview
            tvTvShowRating.text = resources.getString(R.string.rating, tvShow.data?.vote_average)

            Glide.with(this@DetailTvShowActivity)
                .load(tvShow.data?.baseURL.plus(tvShow.data?.poster_path))
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgTvShowImage)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        this.menu = menu
        viewModel.getTvShow.observe(this, { mTvShow ->
            if (mTvShow != null) {
                when (mTvShow.status) {
                    SUCCESS -> if (mTvShow.data != null) {
                        val state = mTvShow.data.favorited
                        setFavoriteState(state)
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
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