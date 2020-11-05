package com.faisal.moviecataloguesubmission3.view.home

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.utils.EspressoIdlingResource
import com.faisal.moviecataloguesubmission3.view.movie.MovieAdapter
import com.faisal.moviecataloguesubmission3.view.tvshow.TvShowAdapter
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun listMovie() {
        SystemClock.sleep(4000)

        onView(withId(R.id.rv_list)).check(matches(isDisplayed()))

        SystemClock.sleep(1000)

        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions.scrollToPosition<MovieAdapter.MovieViewHolder>(
                19
            )
        )

        SystemClock.sleep(2000)


        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                19,
                click()
            )
        )

        SystemClock.sleep(1000)

        onView(withId(R.id.floating_ab_movie)).perform(click())

        SystemClock.sleep(1000)

        Espresso.pressBack()
    }

    @Test
    fun listMovieFavorite() {
        onView(withContentDescription("Favorite")).perform(click())
        onView(withContentDescription("Favorite")).perform(click())

        SystemClock.sleep(1000)

        onView(withId(R.id.rv_list_movie_favorite)).check(matches(isDisplayed()))

        SystemClock.sleep(1000)

        onView(withId(R.id.rv_list_movie_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        SystemClock.sleep(1000)

        onView(withId(R.id.floating_ab_movie)).perform(click())

        SystemClock.sleep(1000)

        Espresso.pressBack()
    }

    @Test
    fun listTvShow() {
        onView(withContentDescription("Tv Show")).perform(click())
        onView(withContentDescription("Tv Show")).perform(click())

        SystemClock.sleep(4000)

        onView(withId(R.id.rv_list_tv)).check(matches(isDisplayed()))

        SystemClock.sleep(1000)

        onView(withId(R.id.rv_list_tv)).perform(
            RecyclerViewActions.scrollToPosition<TvShowAdapter.TvShowViewHolder>(
                19
            )
        )

        SystemClock.sleep(2000)

        onView(withId(R.id.rv_list_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                19,
                click()
            )
        )

        SystemClock.sleep(1000)

        onView(withId(R.id.floating_ab_tv)).perform(click())

        SystemClock.sleep(1000)

        Espresso.pressBack()
    }

    @Test
    fun listTvShowFavorite() {
        onView(withContentDescription("Favorite")).perform(click())
        onView(withContentDescription("Favorite")).perform(click())

        SystemClock.sleep(1000)

        onView(withText("TV SHOW")).perform(click())

        SystemClock.sleep(1000)

        onView(withId(R.id.rv_list_tv_show_favorite)).check(matches(isDisplayed()))

        SystemClock.sleep(1000)


        onView(withId(R.id.rv_list_tv_show_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        SystemClock.sleep(1000)

        onView(withId(R.id.floating_ab_tv)).perform(click())

        SystemClock.sleep(1000)

        Espresso.pressBack()
    }
}