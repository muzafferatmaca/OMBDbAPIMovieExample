package com.muzafferatmaca.ombdbapimovieexample.model

/**
 * Created by Muzaffer Atmaca on 9.06.2022.
 */
import com.google.gson.annotations.SerializedName


data class Ratings (

    @SerializedName("Source" ) var Source : String? = null,
    @SerializedName("Value"  ) var Value  : String? = null

)