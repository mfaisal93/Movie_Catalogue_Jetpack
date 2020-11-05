package com.faisal.moviecataloguesubmission3.view.tvshow


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
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val adapter = TvShowAdapter()
            progress_tv_show.visibility = View.VISIBLE
            rv_list_tv.adapter = adapter
            rv_list_tv.layoutManager = LinearLayoutManager(context)
            rv_list_tv.setHasFixedSize(true)

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getTvShow().observe(this, Observer { tvShow ->
                if (tvShow != null) {
                    progress_tv_show.visibility = View.GONE
                    adapter.setTvShow(tvShow)
                    adapter.notifyDataSetChanged()
                }
            })

        }
    }
}
