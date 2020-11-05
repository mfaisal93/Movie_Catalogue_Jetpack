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
import kotlinx.android.synthetic.main.fragment_tv_show_favorite.*

class TvShowFavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowFavoriteViewModel::class.java]
            val adapterTvShow = TvShowFavoriteAdapter()
            progress_tv_show_favorite.visibility = View.VISIBLE

            viewModel.getTvShowFavorite().observe(this, Observer {tvShow ->
                if (tvShow != null){
                    progress_tv_show_favorite.visibility = View.GONE
                    adapterTvShow.submitList(tvShow)
                    adapterTvShow.notifyDataSetChanged()
                }
            })

            with(rv_list_tv_show_favorite){
                adapter = adapterTvShow
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

}
