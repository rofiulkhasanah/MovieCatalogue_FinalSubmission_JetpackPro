package com.dicoding.moviecatalogue.ui.favorite.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.databinding.ItemsFavoriteBinding
import com.dicoding.moviecatalogue.ui.detail.movie.DetailMovieActivity

class FavoriteTvShowAdapter(private val callbackTvShow: FavoriteTvShowFragmentCallback) :
    PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

//    private val listTvShow = ArrayList<TvShowEntity>()
//
//    fun setMovie(tvShow: List<TvShowEntity>?) {
//        this.listTvShow.clear()
//        if (tvShow != null) {
//            this.listTvShow.addAll(tvShow)
//        }
//    }

    inner class TvShowViewHolder(private val binding: ItemsFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.name
                tvRating.text = itemView.resources.getString(R.string.rating, tvShow.vote_average)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, tvShow.id)
                    it.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callbackTvShow.onShareTvShowClick(tvShow) }
                Glide.with(itemView.context)
                    .load(tvShow.baseURL.plus(tvShow.poster_path))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemFavoriteBinding =
            ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemFavoriteBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    fun getSwipeData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

}