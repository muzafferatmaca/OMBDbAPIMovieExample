package com.muzafferatmaca.ombdbapimovieexample.service

import com.muzafferatmaca.ombdbapimovieexample.Search
import com.muzafferatmaca.ombdbapimovieexample.model.DetailModel
import com.muzafferatmaca.ombdbapimovieexample.model.SearchModel
import com.muzafferatmaca.ombdbapimovieexample.util.Util.apiKey
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
interface OmdbApi {

    @GET("?")
    fun searchMovie(
       @Query("apikey") api_Key: String = apiKey,
       @Query("s") searchQuery: String
    ): Single<SearchModel>

    @GET("?")
    fun detailMovie(
        @Query("apikey") api_Key: String = apiKey,
        @Query("i") detailQuery : String
    ): Single<DetailModel>
}