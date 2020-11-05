package com.faisal.moviecataloguesubmission3.view.favorite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faisal.moviecataloguesubmission3.R
import com.faisal.moviecataloguesubmission3.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_favorite.*


class MovieFavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            progress_movie_favorite.visibility = View.VISIBLE
            val adapterMovie = MovieFavoriteAdapter()

            viewModel.getMovieFavorite().observe(this, Observer { movie ->
                progress_movie_favorite.visibility = View.GONE
                if (movie != null) {
                    adapterMovie.submitList(movie)
                    adapterMovie.notifyDataSetChanged()
                }
            })

            with(rv_list_movie_favorite) {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = adapterMovie
            }
        }
    }
}
