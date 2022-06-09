package com.muzafferatmaca.ombdbapimovieexample.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * Created by Muzaffer Atmaca on 9.06.2022.
 */
fun hideSoftKeyboard(fragment: Fragment) {
    if (fragment.activity!!.getCurrentFocus() == null){
        return
    }
    val inputMethodManager = fragment.activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(fragment.activity!!.getCurrentFocus()!!.getWindowToken(), 0)
}