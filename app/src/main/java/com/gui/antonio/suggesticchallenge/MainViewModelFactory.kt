package com.gui.antonio.suggesticchallenge

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = MainRepository(context)
        val useCase = GetDaysUseCase(repository)
        return MainViewModel(useCase) as T
    }
}