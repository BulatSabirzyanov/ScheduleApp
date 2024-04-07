package com.example.schedule.presentation.ui.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.usecases.DeleteScheduleListUseCase
import com.example.feature_api.usecases.GetAllScheduleListsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author b.sabirzyanov
 */
class MainViewModel @Inject constructor(
    private val getAllScheduleListsUseCase: GetAllScheduleListsUseCase,
    private val deleteScheduleListUseCase: DeleteScheduleListUseCase
) :
    ViewModel() {


    private val _scheduleLists = MutableStateFlow<List<ScheduleApiList>>(emptyList())
    val scheduleLists: StateFlow<List<ScheduleApiList>> = _scheduleLists


    init {
        loadScheduleLists()

    }

    private fun loadScheduleLists() {
        viewModelScope.launch {
            getAllScheduleListsUseCase.invoke().collect { lists ->
                _scheduleLists.value = lists
            }
        }
    }

    fun deleteScheduleItem(scheduleApiList: ScheduleApiList) {
        viewModelScope.launch {
            deleteScheduleListUseCase.invoke(scheduleApiList)
        }
    }
}