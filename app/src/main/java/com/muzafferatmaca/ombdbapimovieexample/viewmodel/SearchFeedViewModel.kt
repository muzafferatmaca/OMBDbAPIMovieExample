package com.muzafferatmaca.ombdbapimovieexample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.ombdbapimovieexample.Search

/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
class SearchFeedViewModel (application: Application) : BaseViewModel(application) {

    val searchMovie = MutableLiveData<List<Search>>()
    val movieError = MutableLiveData<Boolean>()
    val movieLoading = MutableLiveData<Boolean>()
    val search : String? = null

    fun searchMovie(){

        movieLoading.value = false




    }

}