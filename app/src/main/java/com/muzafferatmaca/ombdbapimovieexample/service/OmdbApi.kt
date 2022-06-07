package com.muzafferatmaca.ombdbapimovieexample.service

import com.muzafferatmaca.ombdbapimovieexample.Search
import com.muzafferatmaca.ombdbapimovieexample.util.Util.apiKey
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muzaffer Atmaca on 7.06.2022.
 */
interface OmdbApi {

    @GET("?")
     suspend fun searchMovie(
        @Query("api_key") api_Key : String = apiKey,
        @Query("q") searchQuery : String,
    ) : Response<List<Search>>



}