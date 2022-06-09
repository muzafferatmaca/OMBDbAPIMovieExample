package com.muzafferatmaca.ombdbapimovieexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.muzafferatmaca.ombdbapimovieexample.R
import com.muzafferatmaca.ombdbapimovieexample.databinding.FragmentDetailMovieBinding
import com.muzafferatmaca.ombdbapimovieexample.viewmodel.DetailMovieViewModel
import com.muzafferatmaca.ombdbapimovieexample.viewmodel.SearchFeedViewModel

class DetailMovieFragment : Fragment() {


    private lateinit var binding: FragmentDetailMovieBinding
    private lateinit var viewModel : DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_movie, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
        viewModel.detailMovie()
        observeLiveData()

    }

    fun observeLiveData(){

        viewModel.detailMovie.observe(viewLifecycleOwner){detailMovie ->

            detailMovie?.let {
                binding.detail = it
            }

        }

    }

}