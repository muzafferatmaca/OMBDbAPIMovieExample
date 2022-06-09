package com.muzafferatmaca.ombdbapimovieexample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.ombdbapimovieexample.Search
import com.muzafferatmaca.ombdbapimovieexample.model.SearchModel
import com.muzafferatmaca.ombdbapimovieexample.service.OmdbApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
class SearchFeedViewModel(application: Application) : BaseViewModel(application) {

    private val omdbApiService = OmdbApiService()
    private val disposable = CompositeDisposable()
    val searchMovie = MutableLiveData<SearchModel>()
    val movieError = MutableLiveData<Boolean>()
    val movieLoading = MutableLiveData<Boolean>()

    fun searchMovie(searchQuery: String) {

        getDataFromAPI(searchQuery)
    }

    private fun getDataFromAPI(searchQuery : String) {

        movieLoading.value = true

        disposable.add(
            omdbApiService.getData(searchQuery)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SearchModel>() {
                    override fun onSuccess(t: SearchModel) {

                        searchMovie.value = t
                        movieError.value = false
                        movieLoading.value = false

                    }

                    override fun onError(e: Throwable) {
                        movieLoading.value = false
                        movieError.value = true
                        e.printStackTrace()
                    }

                }
                )
        )


    }

}