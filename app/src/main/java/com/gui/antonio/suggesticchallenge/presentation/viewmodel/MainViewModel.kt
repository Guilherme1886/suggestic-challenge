package com.gui.antonio.suggesticchallenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.domain.GetDaysUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val getDaysUseCase: GetDaysUseCase
) : ViewModel() {

    private val _getDaysLiveData = MutableLiveData<List<DayModel>>()
    val getDaysLiveData: LiveData<List<DayModel>> = _getDaysLiveData

    fun getDays() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            val days = getDaysUseCase.getDays()
            _getDaysLiveData.postValue(days)
        }
    }
}