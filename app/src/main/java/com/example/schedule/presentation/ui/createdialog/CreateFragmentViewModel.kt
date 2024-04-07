package com.example.schedule.presentation.ui.createdialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.repository.ScheduleRepository
import com.example.feature_api.usecases.CreateScheduleListUseCase
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class CreateFragmentViewModel @Inject constructor(
    private val createScheduleListUseCase: CreateScheduleListUseCase
) : ViewModel() {

    suspend fun createScheduleListItem(scheduleApiList: ScheduleApiList) {
        createScheduleListUseCase.invoke(scheduleApiList)
    }
}