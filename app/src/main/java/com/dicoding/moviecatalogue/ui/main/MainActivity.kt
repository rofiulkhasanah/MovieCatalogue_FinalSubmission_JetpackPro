package com.dicoding.moviecatalogue.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.databinding.ActivityMainBinding
import com.dicoding.moviecatalogue.ui.favorite.FavoriteActivity
import com.dicoding.moviecatalogue.ui.movie.MovieFragment
import com.dicoding.moviecatalogue.ui.tvshow.TvShowFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movieFragment = MovieFragment()
    private val tvShowFragment = TvShowFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moveFragment(movieFragment)
        binding.btnNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.nav_movie -> moveFragment(movieFragment)
                R.id.nav_tvShow -> moveFragment(tvShowFragment)
            }
        }
    }

    private fun moveFragment(fragment: Fragment) {
        val trans = supportFragmentManager.beginTransaction()

        trans.replace(R.id.wrapper, fragment)
        trans.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_favorite -> {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}