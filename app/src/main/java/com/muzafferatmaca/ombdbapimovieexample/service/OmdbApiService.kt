package com.muzafferatmaca.ombdbapimovieexample.service

import com.muzafferatmaca.ombdbapimovieexample.Search
import com.muzafferatmaca.ombdbapimovieexample.model.SearchModel
import com.muzafferatmaca.ombdbapimovieexample.util.Util.apiKey
import com.muzafferatmaca.ombdbapimovieexample.util.Util.baseUrl
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
class OmdbApiService {

    private val api = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(OmdbApi::class.java)


    fun getData(): Single<SearchModel> {
   // fun getData(searchQuery: String): Single<List<SearchModel>> {

       // return api.searchMovie(apiKey, searchQuery)
        return api.searchMovie()

    }


}