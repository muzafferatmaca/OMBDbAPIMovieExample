package com.muzafferatmaca.ombdbapimovieexample.model

/**
 * Created by Muzaffer Atmaca on 9.06.2022.
 */
import com.google.gson.annotations.SerializedName


data class DetailModel (

    @SerializedName("Title"        ) var Title        : String?        = null,
    @SerializedName("Year"         ) var Year         : String?        = null,
    @SerializedName("Rated"        ) var Rated        : String?        = null,
    @SerializedName("Released"     ) var Released     : String?        = null,
    @SerializedName("Runtime"      ) var Runtime      : String?        = null,
    @SerializedName("Genre"        ) var Genre        : String?        = null,
    @SerializedName("Director"     ) var Director     : String?        = null,
    @SerializedName("Writer"       ) var Writer       : String?        = null,
    @SerializedName("Actors"       ) var Actors       : String?        = null,
    @SerializedName("Plot"         ) var Plot         : String?        = null,
    @SerializedName("Language"     ) var Language     : String?        = null,
    @SerializedName("Country"      ) var Country      : String?        = null,
    @SerializedName("Awards"       ) var Awards       : String?        = null,
    @SerializedName("Poster"       ) var Poster       : String?        = null,
    @SerializedName("Ratings"      ) var Ratings      : List<Ratings>? = null,
    @SerializedName("Metascore"    ) var Metascore    : String?        = null,
    @SerializedName("imdbRating"   ) var imdbRating   : String?        = null,
    @SerializedName("imdbVotes"    ) var imdbVotes    : String?        = null,
    @SerializedName("imdbID"       ) var imdbID       : String?        = null,
    @SerializedName("Type"         ) var Type         : String?        = null,
    @SerializedName("totalSeasons" ) var totalSeasons : String?        = null,
    @SerializedName("Response"     ) var Response     : String?        = null

)