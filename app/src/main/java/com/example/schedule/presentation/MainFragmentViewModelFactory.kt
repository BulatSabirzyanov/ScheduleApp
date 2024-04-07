package com.example.schedule.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider
import javax.inject.Inject


/**
 * @author b.sabirzyanov
 */

class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModels[modelClass] ?: throw IllegalStateException("ViewModel class $modelClass not found")
        return viewModelProvider.get() as T
    }
}