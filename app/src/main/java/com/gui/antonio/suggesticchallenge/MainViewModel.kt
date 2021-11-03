package com.gui.antonio.suggesticchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val getDaysUseCase: GetDaysUseCase
) : ViewModel() {

    private val _getDaysLiveData = MutableLiveData<List<DayModel>>()
    val getDaysLiveData: LiveData<List<DayModel>> = _getDaysLiveData

    fun getDays() {
        _getDaysLiveData.value = getDaysUseCase.getDays()
    }
}