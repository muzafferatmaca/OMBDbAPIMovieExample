package com.muzafferatmaca.ombdbapimovieexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.muzafferatmaca.ombdbapimovieexample.R
import com.muzafferatmaca.ombdbapimovieexample.databinding.FragmentSearchMovieBinding


class SearchMovieFragment : Fragment() {

    private lateinit var binding: FragmentSearchMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_movie,container,false)
        return binding.root
    }

}