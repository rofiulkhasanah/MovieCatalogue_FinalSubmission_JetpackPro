package com.dicoding.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.databinding.ItemsFavoriteBinding
import com.dicoding.moviecatalogue.ui.detail.movie.DetailMovieActivity

class FavoriteMovieAdapter(private val callbackMovie: FavoriteMovieFragmentCallback) :
    PagedListAdapter<MovieEntity, FavoriteMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


    inner class MovieViewHolder(private val binding: ItemsFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvRating.text = itemView.resources.getString(R.string.rating, movie.vote_average)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.id)
                    it.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callbackMovie.onShareMovieClick(movie) }
                Glide.with(itemView.context)
                    .load(movie.baseURL.plus(movie.poster_path))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemFavoriteBinding =
            ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemFavoriteBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    fun getSwipeData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)
}