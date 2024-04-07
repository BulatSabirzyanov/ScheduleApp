package com.example.schedule.presentation.ui.createdialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.repository.ScheduleRepository
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class CreateFragmentViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    private val _createSuccess = MutableLiveData<Boolean>()
    val createSuccess: LiveData<Boolean> = _createSuccess

    suspend fun createScheduleListItem(scheduleApiList: ScheduleApiList) {
        scheduleRepository.createScheduleListItem(scheduleApiList)
        _createSuccess.value = true
    }
}