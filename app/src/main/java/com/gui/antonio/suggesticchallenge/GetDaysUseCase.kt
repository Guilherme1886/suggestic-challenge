package com.gui.antonio.suggesticchallenge

class GetDaysUseCase(private val repository: MainRepository) {
    fun getDays() : List<DayModel> {
        return repository.getDays()
    }
}