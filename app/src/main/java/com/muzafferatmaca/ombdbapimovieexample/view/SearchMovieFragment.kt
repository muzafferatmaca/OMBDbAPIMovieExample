package com.muzafferatmaca.ombdbapimovieexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.muzafferatmaca.ombdbapimovieexample.R
import com.muzafferatmaca.ombdbapimovieexample.adapter.SearchRecyclerAdapter
import com.muzafferatmaca.ombdbapimovieexample.databinding.FragmentSearchMovieBinding
import com.muzafferatmaca.ombdbapimovieexample.viewmodel.SearchFeedViewModel
import kotlinx.android.synthetic.main.fragment_search_movie.*


class SearchMovieFragment : Fragment() {

    private lateinit var binding: FragmentSearchMovieBinding
    private lateinit var viewModel: SearchFeedViewModel
    private val searchMovieAdapter = SearchRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SearchFeedViewModel::class.java)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    viewModel.searchMovie(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = searchMovieAdapter

        observeLiveData()

    }

    private fun observeLiveData() {

        viewModel.searchMovie.observe(viewLifecycleOwner) { searchMovie ->

            searchMovie.search?.let {

                recyclerView.visibility = View.VISIBLE
                searchMovieAdapter.searchList = it

            }


        }

        viewModel.movieError.observe(viewLifecycleOwner) { error ->

            error?.let {


                if (it) {
                    errorTextView.setText(R.string.errorMessage)
                    errorTextView.visibility = View.VISIBLE
                    movieProgressBar.visibility = View.GONE
                } else {
                    errorTextView.visibility = View.GONE
                }

            }

        }

        viewModel.movieLoading.observe(viewLifecycleOwner) { loading ->

            loading?.let {

                if (it) {

                    movieProgressBar.visibility = View.VISIBLE
                    errorTextView.visibility = View.GONE
                    recyclerView.visibility = View.GONE

                } else {
                    movieProgressBar.visibility = View.INVISIBLE
                }

            }

        }


    }


}