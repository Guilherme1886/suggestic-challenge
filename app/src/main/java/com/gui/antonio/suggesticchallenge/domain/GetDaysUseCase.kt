package com.gui.antonio.suggesticchallenge.domain

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.data.repository.MainRepository

class GetDaysUseCase(
    private val repository: MainRepository,
    private val gson: Gson
) {
    fun getDays(): List<DayModel> {
        return try {
            val json = repository.getDays() ?: String()
            gson.fromJson(json, object : TypeToken<List<DayModel>>() {}.type) as List<DayModel>
        } catch (j: JsonSyntaxException) {
            emptyList()
        }
    }
}