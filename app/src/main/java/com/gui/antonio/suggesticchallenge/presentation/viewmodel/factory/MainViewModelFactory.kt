package com.gui.antonio.suggesticchallenge.presentation.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.gui.antonio.suggesticchallenge.domain.GetDaysUseCase
import com.gui.antonio.suggesticchallenge.data.repository.MainRepository
import com.gui.antonio.suggesticchallenge.presentation.viewmodel.MainViewModel

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = MainRepository(context)
        val useCase = GetDaysUseCase(repository, Gson())
        return MainViewModel(useCase) as T
    }
}