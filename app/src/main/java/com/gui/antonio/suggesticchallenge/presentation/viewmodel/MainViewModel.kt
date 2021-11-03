package com.gui.antonio.suggesticchallenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.domain.GetDaysUseCase

class MainViewModel(
    private val getDaysUseCase: GetDaysUseCase
) : ViewModel() {

    private val _getDaysLiveData = MutableLiveData<List<DayModel>>()
    val getDaysLiveData: LiveData<List<DayModel>> = _getDaysLiveData

    fun getDays() {
        _getDaysLiveData.value = getDaysUseCase.getDays()
    }
}