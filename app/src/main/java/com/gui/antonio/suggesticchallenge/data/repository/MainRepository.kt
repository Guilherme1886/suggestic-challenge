package com.gui.antonio.suggesticchallenge.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.helper.getJsonDataFromAsset

class MainRepository(private val context: Context) {
    fun getDays() : List<DayModel> {
        val jsonFileString = getJsonDataFromAsset(context, "data.json")
        println("json: $jsonFileString")

        val gson = Gson()
        val dayModelType = object : TypeToken<List<DayModel>>() {}.type

        val dayModel: List<DayModel> = gson.fromJson(jsonFileString, dayModelType)
        println("model: $dayModel")
        return dayModel
    }
}