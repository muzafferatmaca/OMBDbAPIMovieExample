package com.muzafferatmaca.ombdbapimovieexample.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muzafferatmaca.ombdbapimovieexample.R

/**
 * Created by Muzaffer Atmaca on 8.06.2022.
 */

fun ImageView.downloadFromUrl(url : String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.color.black)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable{

    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }

}

@BindingAdapter("android:downloadUrl")
fun downloadImage(view : ImageView,url : String?){

    view.downloadFromUrl(url, placeholderProgressBar(view.context))

}

