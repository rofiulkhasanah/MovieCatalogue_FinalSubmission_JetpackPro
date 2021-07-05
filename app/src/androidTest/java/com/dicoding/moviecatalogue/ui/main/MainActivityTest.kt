package com.dicoding.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.utils.DataTMDB
import com.dicoding.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dataMovie = DataTMDB.generateMovies()
    private val dataTvShow = DataTMDB.generateTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (dataMovie.size)
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_movieTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieRating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieDate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieDescription))
            .check(matches(isDisplayed()))
    }

    @Test
    fun setFavoriteMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )

        onView(withId(R.id.tv_movieTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieRating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieDate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_movieDescription))
            .check(matches(isDisplayed()))

        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId((R.id.nav_favorite))).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (dataMovie.size)
        )
        onView(isRoot()).perform(ViewActions.pressBack())

    }

    @Test
    fun loadTvShow() {
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataTvShow.size)
        )

    }

    @Test
    fun loadDetailTvShow() {
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_tvShowTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowTitle))
            .check(matches(withText(dataTvShow[0].name)))
        onView(withId(R.id.tv_tvShowRating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowRating))
            .check(matches(withText("Rating : ${dataTvShow[0].vote_average}")))
        onView(withId(R.id.tv_tvShowDescription))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowDescription))
            .check(matches(withText(dataTvShow[0].overview)))
    }

    @Test
    fun LoadFavoriteMovies() {
        onView(withId((R.id.nav_favorite))).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (dataMovie.size)
        )
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun LoadFavoriteTvShows() {
        onView(withId((R.id.nav_favorite))).perform(click())
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.rv_favorite_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (dataTvShow.size)
        )
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun setFavoriteTvShow() {
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId((R.id.nav_tvShow))).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_tvShowTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowTitle))
            .check(matches(withText(dataTvShow[0].name)))
        onView(withId(R.id.tv_tvShowRating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowRating))
            .check(matches(withText("Rating : ${dataTvShow[0].vote_average}")))
        onView(withId(R.id.tv_tvShowDescription))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShowDescription))
            .check(matches(withText(dataTvShow[0].overview)))

        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId((R.id.nav_favorite))).perform(click())
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.rv_favorite_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>
                (dataTvShow.size)
        )
        onView(isRoot()).perform(ViewActions.pressBack())

    }
}