package com.faisal.moviecataloguesubmission3.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.view.favorite.FavoriteFragment
import com.faisal.moviecataloguesubmission3.view.movie.MovieFragment
import com.faisal.moviecataloguesubmission3.view.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.movies -> { getFragment(MovieFragment()) }
                R.id.tv_show -> { getFragment(TvShowFragment())}
                R.id.favorite -> {getFragment(FavoriteFragment())}
            }
            true
        }
        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.movies
        }
    }

    private fun getFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(
                R.id.container_layout,
                fragment, fragment::class.java.simpleName
            ).commit()
    }
}
