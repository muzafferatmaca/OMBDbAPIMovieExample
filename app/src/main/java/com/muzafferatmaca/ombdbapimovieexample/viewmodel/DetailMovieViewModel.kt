package com.muzafferatmaca.ombdbapimovieexample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.muzafferatmaca.ombdbapimovieexample.model.DetailModel
import com.muzafferatmaca.ombdbapimovieexample.service.OmdbApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Muzaffer Atmaca on 8.06.2022.
 */
class DetailMovieViewModel(application: Application) : BaseViewModel(application) {

    private val omdbApiService = OmdbApiService()
    private val disposable = CompositeDisposable()
    val detailMovie = MutableLiveData<DetailModel>()
    val detailError = MutableLiveData<Boolean>()
    val detailLoading = MutableLiveData<Boolean>()

    fun getDataFromSearch(imdbID : String){

        detailLoading.value = true
        disposable.add(
            omdbApiService.getDetail(imdbID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<DetailModel>(){
                    override fun onSuccess(t: DetailModel) {

                       detailMovie.value = t
                        detailError.value=false
                        detailLoading.value=false
                    }

                    override fun onError(e: Throwable) {

                        e.printStackTrace()
                        detailError.value=true
                        detailLoading.value=false

                    }

                })
        )


    }



}