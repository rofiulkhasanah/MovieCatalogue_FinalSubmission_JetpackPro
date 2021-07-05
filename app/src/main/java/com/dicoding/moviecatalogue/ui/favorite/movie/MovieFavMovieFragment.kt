package com.dicoding.moviecatalogue.ui.favorite.movie

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
import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.databinding.FragmentMovieFavBinding
import com.dicoding.moviecatalogue.ui.favorite.FavoriteViewModel
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MovieFavMovieFragment : Fragment(), FavoriteMovieFragmentCallback {

    private var fragmentMovieFavFragment: FragmentMovieFavBinding? = null
    private val binding get() = fragmentMovieFavFragment

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieFavFragment = FragmentMovieFavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteMovie)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            adapter = FavoriteMovieAdapter(this)
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteMovies().observe(this, { movies ->
                binding?.progressBar?.visibility = View.GONE
//                adapter.setMovie(movies)
//                adapter.notifyDataSetChanged()
                adapter.submitList(movies)
            })

            binding?.rvFavoriteMovie?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavoriteMovie?.setHasFixedSize(true)
            binding?.rvFavoriteMovie?.adapter = adapter
        }
    }

    override fun onShareMovieClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText("Lihat Film ${movie.title} sekarang")
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
                val movieEntity = adapter.getSwipeData(swipedPosition)
                movieEntity?.let { viewModel.setMovieFavorite(it) }

                val snackbar = Snackbar.make(
                    view as View,
                    "Batalkan menghapus item sebelumnya?",
                    Snackbar.LENGTH_LONG
                )
                snackbar.setAction("OK") { view ->
                    movieEntity?.let { viewModel.setMovieFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}