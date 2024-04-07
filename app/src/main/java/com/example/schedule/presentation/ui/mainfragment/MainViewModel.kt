package com.example.schedule.presentation.ui.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.repository.ScheduleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author b.sabirzyanov
 */
class MainViewModel @Inject constructor(private val scheduleRepository: ScheduleRepository) :
    ViewModel() {


    private val _scheduleLists = MutableStateFlow<List<ScheduleApiList>>(emptyList())
    val scheduleLists: StateFlow<List<ScheduleApiList>> = _scheduleLists


    init {
        loadScheduleLists()

    }

    private fun loadScheduleLists() {
        viewModelScope.launch {
            scheduleRepository.getAllScheduleLists().collect { lists ->
                _scheduleLists.value = lists
            }
        }
    }

    private fun createScheduleList(scheduleApiList: ScheduleApiList) {
        viewModelScope.launch {
            scheduleRepository.createScheduleListItem(scheduleApiList)
            loadScheduleLists()
        }
    }
    fun deleteScheduleItem(scheduleApiList: ScheduleApiList) {
        viewModelScope.launch {
            scheduleRepository.deleteScheduleListItem(scheduleApiList)
        }
    }
}