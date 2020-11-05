package com.faisal.moviecataloguesubmission3.view.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.faisal.moviecataloguesubmission3.R
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(),childFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }


}
