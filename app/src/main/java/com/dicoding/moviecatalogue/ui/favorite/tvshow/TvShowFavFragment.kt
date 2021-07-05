package com.dicoding.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.databinding.FragmentTvShowFavBinding
import com.dicoding.moviecatalogue.ui.favorite.FavoriteViewModel
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvShowFavFragment : Fragment(), FavoriteTvShowFragmentCallback {

    private var fragmentTvShowFavFragment: FragmentTvShowFavBinding? = null
    private val binding get() = fragmentTvShowFavFragment

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowFavFragment = FragmentTvShowFavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteTvShow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            adapter = FavoriteTvShowAdapter(this)
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteTvShow().observe(this, { tvShows ->
                binding?.progressBar?.visibility = View.GONE
//                adapter.setMovie(tvShows)
//                adapter.notifyDataSetChanged()
                adapter.submitList(tvShows)
            })

            binding?.rvFavoriteTvShow?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavoriteTvShow?.setHasFixedSize(true)
            binding?.rvFavoriteTvShow?.adapter = adapter
        }
    }


    override fun onShareTvShowClick(tvShow: TvShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText("Lihat Film ${tvShow.name} sekarang")
                .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = adapter.getSwipeData(swipedPosition)
                tvShowEntity?.let { viewModel.setTvShowFavorite(it) }

                val snackbar = Snackbar.make(
                    view as View,
                    "Batalkan menghapus item sebelumnya?",
                    Snackbar.LENGTH_LONG
                )
                snackbar.setAction("OK") { view ->
                    tvShowEntity?.let { viewModel.setTvShowFavorite(it) }
                }
                snackbar.show()
            }
        }
    })

}