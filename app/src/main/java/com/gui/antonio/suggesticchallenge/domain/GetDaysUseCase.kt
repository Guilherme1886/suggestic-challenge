package com.gui.antonio.suggesticchallenge.domain

import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.data.repository.MainRepository

class GetDaysUseCase(private val repository: MainRepository) {
    fun getDays() : List<DayModel> {
        return repository.getDays()
    }
}