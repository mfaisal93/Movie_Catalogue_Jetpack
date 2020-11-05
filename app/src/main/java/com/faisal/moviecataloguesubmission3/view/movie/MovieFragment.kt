package com.faisal.moviecataloguesubmission3.view.movie


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
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val adapter =
                MovieAdapter()
            progress_movie.visibility = View.VISIBLE
            rv_list.adapter = adapter
            rv_list.layoutManager = LinearLayoutManager(context)
            rv_list.setHasFixedSize(true)

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            viewModel.getMovie().observe(this, Observer { movie ->
                if (movie != null) {
                    progress_movie.visibility = View.GONE
                    adapter.setMovie(movie)
                    adapter.notifyDataSetChanged()
                }
            })
        }
    }
}
