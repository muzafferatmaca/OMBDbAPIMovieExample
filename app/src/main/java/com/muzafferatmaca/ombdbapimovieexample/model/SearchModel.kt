package com.muzafferatmaca.ombdbapimovieexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.muzafferatmaca.ombdbapimovieexample.Search

/**
 * Created by Muzaffer Atmaca on 9.06.2022.
 */
data class SearchModel(

    @Expose @SerializedName("Search"      ) var search : List<Search>? = null,
    @Expose @SerializedName("totalResults") var totalResults: String? = null,
    @Expose @SerializedName("Response"    ) var response: String? = null

)
