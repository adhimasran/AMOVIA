package com.adhi.amovia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.adhi.amovia.R
import com.adhi.amovia.databinding.FragmentHomeBinding
import com.adhi.amovia.ui.home.adapter.OnAirTvAdapter
import com.adhi.amovia.ui.home.adapter.PopularMovieAdapter
import com.adhi.amovia.ui.home.adapter.PopularTvAdapter
import com.adhi.amovia.ui.home.adapter.UpcomingMovieAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val popularMovieAdapter = PopularMovieAdapter()
    private val upcomingMovieAdapter = UpcomingMovieAdapter()
    private val popularTvAdapter = PopularTvAdapter()
    private val onAirTvAdapter = OnAirTvAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        setData()
    }

    private fun setupAdapter() {
        binding?.apply {
            rvPopularMovie.adapter = popularMovieAdapter
            rvUpcomingMovie.adapter = upcomingMovieAdapter
            rvPopularTv.adapter = popularTvAdapter
            rvOnAirTv.adapter = onAirTvAdapter
        }
    }

    private fun setData() {
        homeViewModel.apply {
            getPopularMovie().observe(viewLifecycleOwner, {
                popularMovieAdapter.setMovie(it)
            })

            getUpcomingMovie().observe(viewLifecycleOwner, {
                upcomingMovieAdapter.setMovie(it)
            })

            getOnAirTv().observe(viewLifecycleOwner, {
                onAirTvAdapter.setData(it)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}