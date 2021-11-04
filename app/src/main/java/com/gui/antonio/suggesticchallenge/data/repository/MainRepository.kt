package com.gui.antonio.suggesticchallenge.data.repository

import android.content.Context
import com.gui.antonio.suggesticchallenge.helper.DATA_JSON
import com.gui.antonio.suggesticchallenge.helper.getJsonDataFromAsset

class MainRepository(
    private val context: Context
) {
    fun getDays(): String? = getJsonDataFromAsset(context, DATA_JSON)
}