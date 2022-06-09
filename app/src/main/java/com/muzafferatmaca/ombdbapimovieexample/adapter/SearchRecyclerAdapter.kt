package com.muzafferatmaca.ombdbapimovieexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.ombdbapimovieexample.R
import com.muzafferatmaca.ombdbapimovieexample.Search
import com.muzafferatmaca.ombdbapimovieexample.databinding.SearchRowBinding
import com.muzafferatmaca.ombdbapimovieexample.view.SearchMovieFragmentDirections
import kotlinx.android.synthetic.main.search_row.view.*


/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
class SearchRecyclerAdapter(var searchList : List<Search>) : RecyclerView.Adapter<SearchRecyclerAdapter.SearchViewHolder>(),SearchClickListener {

    class SearchViewHolder(val itemBinding: SearchRowBinding ) : RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<SearchRowBinding>(inflater,R.layout.search_row,parent,false)
        return SearchViewHolder(view)

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.itemBinding.search = searchList[position]
        holder.itemBinding.listener = this

    }

    override fun getItemCount(): Int {
       return searchList.size
    }

    override fun onSearchClick(view: View) {

        val imdbID = view.imdbIDTextView.text.toString()
        val action = SearchMovieFragmentDirections.actionSearchMovieFragmentToDetailMovieFragment(imdbID)
        Navigation.findNavController(view).navigate(action)


    }




}

